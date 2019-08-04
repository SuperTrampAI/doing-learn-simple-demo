package com.supertrampai.springbootsimplefilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/04 15:15
 */
@Configuration
public class AppConfigFilter {

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestResponseLoggingFilter());
        registrationBean.addUrlPatterns("/books/*");
        registrationBean.setOrder(3); //set precedence
        return registrationBean;
    }

}
