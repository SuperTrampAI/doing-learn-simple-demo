package com.supertrampai.springbootsimplemybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.supertrampai.springbootsimplemybatis.mapper")
public class SpringBootSimpleMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSimpleMybatisApplication.class, args);
    }

}
