package com.supertrampai.springbootsimplemail.service;

import com.supertrampai.springbootsimplemail.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/18 10:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("lxh95529@outlook.com","test simple mail"," hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("lxh95529@outlook.com","test simple mail",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="F:\\fantasticfunicular.sql";
        mailService.sendAttachmentsMail("lxh95529@outlook.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "F:\\weixinImage\\20190627174219.jpg";

        mailService.sendInlineResourceMail("lxh95529@outlook.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }

}
