/*
package com.supertrampai.springbootsimpleswagger;

import com.supertrampai.springbootsimpleswagger.domain.Book;
import com.supertrampai.springbootsimpleswagger.util.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.*;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

*/
/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/21 20:01
 *//*

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                .responseModel(new ModelRef("string"))
                                .build()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.supertrampai"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("SuperTrampAI","https://supertrampai.com/","lxh800109@gmail.com");
        return new ApiInfoBuilder()
                .title("lxh800109@gmail.com - SuperTrampAI接口文档 ")
                .version(DateUtil.NowStr(null))
                .contact(contact)
                .build();
    }

}*/
