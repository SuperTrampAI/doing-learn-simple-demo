package com.supertrampai.springbootsimpleredis;

import redis.clients.jedis.Jedis;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/04 11:38
 */
public class Publisher {

    /**
     * 消息发布er
     */
    public  void pub(){
        Jedis jPublisher = new Jedis();
        jPublisher.publish("channel", "test message");
    }

}
