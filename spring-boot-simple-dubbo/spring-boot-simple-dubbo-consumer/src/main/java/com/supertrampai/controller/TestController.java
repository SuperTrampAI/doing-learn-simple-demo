package com.supertrampai.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supertrampai.domain.Book;
import com.supertrampai.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 0:42 2019/8/29
 * @Modified By:
 */
@RestController
@RequestMapping("/")
public class TestController {
    @Reference(version = "1.0.0")
    private TestService testService;

    @GetMapping("hello")
    public String hello() {
        return testService.sayHello("Hello springboot and dubbo!");
    }

    @GetMapping("user")
    public Book user() {
        return testService.findUser();
    }
}