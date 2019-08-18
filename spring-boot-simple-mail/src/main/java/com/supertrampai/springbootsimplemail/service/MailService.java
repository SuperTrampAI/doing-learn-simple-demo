package com.supertrampai.springbootsimplemail.service;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-18 10:50
 */
public interface MailService {

    public void sendSimpleMail(String to, String subject, String content);

    public void sendHtmlMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}
