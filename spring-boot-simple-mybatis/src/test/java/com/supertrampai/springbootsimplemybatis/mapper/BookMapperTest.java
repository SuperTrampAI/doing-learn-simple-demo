package com.supertrampai.springbootsimplemybatis.mapper;

import com.supertrampai.springbootsimplemybatis.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/11 12:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookMapperXML bookMapperXML;

    @Test
    public void testInsert() throws Exception {
        bookMapper.insert(new Book("aa1", 1, "publishM1"));
        bookMapper.insert(new Book("bb1", 2, "publishM2"));
        bookMapper.insert(new Book("cc1", 3, "publishM3"));

        Assert.assertEquals(3, bookMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<Book> users = bookMapper.getAll();
        System.out.println(users.toString());
    }


    @Test
    public void testUpdate() throws Exception {
        Book book = bookMapper.getOne(12);
        System.out.println(book.toString());
        book.setBname("bnameMybatis");
        bookMapper.update(book);
        Assert.assertTrue(("bnameMybatis".equals(bookMapper.getOne(12).getBname())));
    }

    @Test
    public void testInsertXML() throws Exception {
        bookMapperXML.insert(new Book("aa1", 1, "publishM1",new Date(),123,123,"content1231"));
        bookMapperXML.insert(new Book("bb1", 1, "publishM2",new Date(),123,123,"content1232"));
        bookMapperXML.insert(new Book("cc1", 1, "publishM3",new Date(),123,123,"content1233"));

        //Assert.assertEquals(3, bookMapper.getAll().size());
    }

    @Test
    public void testInsertListXML() throws Exception {

        Book bk1=new Book("aa1", 1, "publishM1",new Date(),123,123,"content1231");
        Book bk2=new Book("aaa1", 1, "publishM1",new Date(),123,123,"content1231");
        Book bk3=new Book("aaa2", 1, "publishM1",new Date(),123,123,"content1231");
        List<Book> books=new ArrayList<Book>();
        books.add(bk1);
        books.add(bk2);
        books.add(bk3);
        bookMapperXML.insertList(books);
        Assert.assertEquals(3, bookMapper.getAll().size());
    }

    @Test
    public void testQueryXML() throws Exception {
        List<Book> users = bookMapperXML.getAll();
        System.out.println(users.toString());
    }


    @Test
    public void testUpdateXML() throws Exception {
        Book book = bookMapperXML.getOne(12);
        System.out.println(book.toString());
        book.setBname("bnameMybatis");
        bookMapper.update(book);
        Assert.assertTrue(("bnameMybatis".equals(bookMapper.getOne(12).getBname())));
    }
}
