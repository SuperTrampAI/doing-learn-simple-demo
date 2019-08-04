package com.supertrampai.springbootsimpleredis.test;

import com.supertrampai.springbootsimpleredis.domain.Book;
import com.supertrampai.springbootsimpleredis.service.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveBook() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void queryById() {
        Book book=bookService.queryById(12);
        System.out.println(book);
    }


}