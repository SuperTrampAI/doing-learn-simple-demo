package com.supertrampai.springbootsimplejms.service;

import com.supertrampai.springbootsimplejms.domain.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/18 23:31
 */
@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }

}
