package com.supertrampai.springbootsimplerabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lxh800109@gmail.com
* @Description
 * @create 2019/08/23 10:41
 * 发送者
 */
//@Component
public class HelloSender {

    /*@Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);//往rabbitmq里面扔数据
    }*/

}
