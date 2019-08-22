package com.supertrampai.springbootsimplewebsocket.domain;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/22 19:45
 */
// 1
public class HelloMessage {

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
