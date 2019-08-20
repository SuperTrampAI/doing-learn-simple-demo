package com.supertrampai.springbootsimplecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootSimpleCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSimpleCacheApplication.class, args);
    }

}
