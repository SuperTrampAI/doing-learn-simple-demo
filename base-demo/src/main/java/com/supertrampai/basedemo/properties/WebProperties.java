package com.supertrampai.basedemo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/02 11:19
 */

@Component
public class WebProperties {

    /**
     * 配置文件的使用
     */
    @Value("${com.supertrampai.web}")
    private String webSite;
    @Value("${com.supertrampai.author}")
    private String author;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
