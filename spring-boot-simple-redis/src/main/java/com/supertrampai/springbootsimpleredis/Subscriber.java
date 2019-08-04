package com.supertrampai.springbootsimpleredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/04 11:23
 */
public class Subscriber {

    /**
     * messaage 消费者
     */
    public void sub(){

        Jedis jSubscriber = new Jedis();
        jSubscriber.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                //handle message
                super.onMessage(channel, message);
            }
        });

    }

}
