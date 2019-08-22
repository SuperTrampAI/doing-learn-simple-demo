package com.supertrampai.springbootsimpleexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSimpleExcelApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootSimpleExcelApplication.class, args);
    }
    // bug 在ReportExcel中 clone关闭
}
