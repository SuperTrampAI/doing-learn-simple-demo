package com.supertrampai.springbootsimplejpa.action;

import com.supertrampai.springbootsimplejpa.domain.Book;
import com.supertrampai.springbootsimplejpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @author lxh800109@gmail.com
 * @create 2019/08/01 20:50
 */
@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/getBookById",method = RequestMethod.GET)
    public Book getBook(@RequestParam Integer bid) {
        Book book=bookService.queryById(bid);
        return book;
    }

    @RequestMapping(value="/helloWorld",method = RequestMethod.GET)
    public String helloWorld() {
        return "hello world";
    }


}
