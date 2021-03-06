package com.supertrampai.springbootsimpleredis.redis;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/04 11:44
 *
 * redis 分布锁
 *
 * 用法：
 * 使用方法，创建RedisLock对象
*     RedisLock lock = new RedisLock(redisTemplate, "lock_" + product.getId());
*     try {
* 	    if (lock.lock()) {}
*     } finally {
* 	    lock.unlock();
*     }
 */
@Slf4j
public class RedisLock {

    private RedisTemplate redisTemplate;
    /**
     * 重试时间
     */
    private static final int DEFAULT_ACQUIRY_RETRY_MILLIS = 1000;
    /**
     * 锁的后缀
     */
    private static final String LOCK_SUFFIX = "_redis_lock";
    /**
     * 锁的key
     */
    private String lockKey;
    /**
     * 锁超时时间，防止线程在入锁以后，防止阻塞后面的线程无法获取锁
     */
    private int expireMsecs = 60 * 1000;
    /**
     * 线程获取锁的等待时间
     */
    private int timeoutMsecs = 1000;
    /**
     * 是否锁定标志
     */
    private volatile boolean locked = false;


    private final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    /**
     * 构造器
     * @param redisTemplate
     * @param lockKey 锁的key
     */
    public RedisLock(RedisTemplate redisTemplate, String lockKey) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey + LOCK_SUFFIX;
    }

    /**
     * 构造器
     * @param redisTemplate
     * @param lockKey 锁的key
     * @param timeoutMsecs 获取锁的超时时间
     */
    public RedisLock(RedisTemplate redisTemplate, String lockKey, int timeoutMsecs) {
        this(redisTemplate, lockKey);
        this.timeoutMsecs = timeoutMsecs;
    }

    /**
     * 构造器
     * @param redisTemplate
     * @param lockKey 锁的key
     * @param timeoutMsecs 获取锁的超时时间
     * @param expireMsecs 锁的有效期
     */
    public RedisLock(RedisTemplate redisTemplate, String lockKey, int timeoutMsecs, int expireMsecs) {
        this(redisTemplate, lockKey, timeoutMsecs);
        this.expireMsecs = expireMsecs;
    }

    public String getLockKey() {
        return lockKey;
    }

    /**
     * 封装和jedis方法
     * @param key
     * @return
     */
    private String get(final String key) {
        Object obj = redisTemplate.opsForValue().get(key);
        return obj != null ? obj.toString() : null;
    }

    /**
     * 封装和jedis方法
     * @param key
     * @param value
     * @return
     */
    private boolean setNX(final String key, final String value) {
        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    /**
     * 封装和jedis方法
     * @param key
     * @param value
     * @return
     */
    private String getSet(final String key, final String value) {
        Object obj = redisTemplate.opsForValue().getAndSet(key,value);
        return obj != null ? (String) obj : null;
    }

    /**
     * 获取锁
     * @return 获取锁成功返回ture，超时返回false
     * @throws InterruptedException
     */
    public synchronized boolean lock() throws InterruptedException {
        logger.info("--------------------------------------------------");
        logger.info("获取分布式锁开始");
        logger.info("--------------------------------------------------");
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            long expires = System.currentTimeMillis() + expireMsecs + 1;
            String expiresStr = String.valueOf(expires); //锁到期时间
            if (this.setNX(lockKey, expiresStr)) {
                locked = true;
                logger.info("--------------------------------------------------");
                logger.info("获取分布式锁成功");
                logger.info("--------------------------------------------------");
                return true;
            }
            //redis里key的时间
            String currentValue = this.get(lockKey);
            //判断锁是否已经过期，过期则重新设置并获取
            if (currentValue != null && Long.parseLong(currentValue) < System.currentTimeMillis()) {
                //设置锁并返回旧值
                String oldValue = this.getSet(lockKey, expiresStr);
                //比较锁的时间，如果不一致则可能是其他锁已经修改了值并获取
                if (oldValue != null && oldValue.equals(currentValue)) {
                    locked = true;
                    logger.info("--------------------------------------------------");
                    logger.info("获取分布式锁成功");
                    logger.info("--------------------------------------------------");
                    return true;
                }
            }
            timeout -= DEFAULT_ACQUIRY_RETRY_MILLIS;
            //延时
            Thread.sleep(DEFAULT_ACQUIRY_RETRY_MILLIS);
        }
        logger.info("--------------------------------------------------");
        logger.info("获取分布式锁失败");
        logger.info("--------------------------------------------------");
        return false;
    }
    /**
     * 释放获取到的锁
     */
    public synchronized void unlock() {
        if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }

}
