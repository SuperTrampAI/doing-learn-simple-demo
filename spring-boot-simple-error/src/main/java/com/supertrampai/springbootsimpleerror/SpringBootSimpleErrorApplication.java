package com.supertrampai.springbootsimpleerror;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSimpleErrorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSimpleErrorApplication.class, args);
    }

    //error.html会覆盖默认的 whitelabel Error Page 错误提示
    //静态错误页面优先级别比error.html高
    //动态模板错误页面优先级比静态错误页面高
}
