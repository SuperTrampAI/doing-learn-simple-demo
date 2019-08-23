package com.supertrampai.springbootsimplerabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/23 10:43
 * 接收者
 */
//@Component
//@RabbitListener(queues = "hello")
public class HelloReceiver {

    /*@RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }*/

}
