package com.supertrampai.springbootsimpleredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/04 10:39
 */
public class JedisGrammar {

    public static void main(String[] args) {

        Jedis jedis =new Jedis();

        // 字符串
        jedis.set("a","123");

        //--------------------------------------------
        //string list
        jedis.lpush("queue/tasks","message1","message2","message3");
        jedis.lpush("queue/tasks","message4");
        //firstTask 集合的第一个值
        System.out.println(jedis.rpop("queue/tasks"));

        //--------------------------------------------
        //set ： 无序集合，会排出重复的内容,并且随机
        jedis.sadd("nicknames","nickname#1");
        jedis.sadd("nicknames","nickname#2");
        jedis.sadd("nicknames","nickname#1");
        jedis.sadd("nicknames","nickname#5");
        jedis.sadd("nicknames","nickname#8");
        jedis.sadd("nicknames","nickname#10");

        Set<String> nicknames = jedis.smembers("nicknames");
        for (String nickname: nicknames){
            System.out.println(nickname);
        }
        //判断值是否存在于set中
        System.out.println(jedis.sismember("nicknames","nickname#1"));

        //--------------------------------------------
        //Hashes  通过前两个值来定位value
        jedis.hset("books","时间的朋友","时间管理");
        jedis.hset("books","时间的朋友","时间管理1");
        jedis.hset("books","高效能人士的七个习惯","时间管理");
        jedis.hset("books","巨婴国","心理学");

        //通过前两个值来定位value
        String bookName=jedis.hget("books","时间的朋友");
        //输出：时间管理
        System.out.println(bookName);

        // 获取books下面的所有数据，返回map
        Map<String, String> fields=jedis.hgetAll("books");
        //获取map下field为“时间的朋友” 后一个相同的field，会覆盖前一个
        String bookNameField=fields.get("时间的朋友");

        //--------------------------------------------
        //Sorted Sets  排序set
        Map<String, Double> scores = new HashMap<>();
        scores.put("PlayerOne", 3000.0);
        scores.put("PlayerTwo", 1500.0);
        scores.put("PlayerThree", 8200.0);
        scores.entrySet().forEach(playerScore -> {
            jedis.zadd("ranking", playerScore.getValue(), playerScore.getKey());
        });
        String player = jedis.zrevrange("ranking", 0, 1).iterator().next();
        long rank = jedis.zrevrank("ranking", "PlayerThree");
        //输出PlayerThree排序以后的下标：PlayerThree最大，所以下标为0
        System.out.println(rank);

        //--------------------------------------------
        //
        String friendsPrefix = "friends#";
        String userOneId = "4352523";
        String userTwoId = "5552321";
        Transaction t = jedis.multi();
        t.sadd(friendsPrefix + userOneId, userTwoId);
        t.sadd(friendsPrefix + userTwoId, userOneId);
        t.exec();
        //System.out.println(t.exec());


    }

}
