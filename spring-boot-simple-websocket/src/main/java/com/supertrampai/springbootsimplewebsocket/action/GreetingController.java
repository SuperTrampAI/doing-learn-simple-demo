package com.supertrampai.springbootsimplewebsocket.action;

import com.supertrampai.springbootsimplewebsocket.domain.Greeting;
import com.supertrampai.springbootsimplewebsocket.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/22 19:47
 */
@Controller
@RequestMapping("websocket")
public class GreetingController {


    /*@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }*/


}