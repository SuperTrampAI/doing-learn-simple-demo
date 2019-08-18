package com.supertrampai.springbootsimpleloadfile.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/18 18:30
 */
@ConfigurationProperties(prefix = "file")
@EnableConfigurationProperties({
        FileStorageProperties.class
})
@Component
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}