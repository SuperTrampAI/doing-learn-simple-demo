package com.supertrampai.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supertrampai.domain.Book;
import com.supertrampai.service.TestService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 0:34 2019/8/29
 * @Modified By:
 */
@Service(version = "1.0.0")
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(new Date()) + ": " + str;
    }

    @Override
    public Book findUser() {
        Book book = new Book();
        book.setBid(213);
        book.setBname("bname");
        return book;
    }
}
