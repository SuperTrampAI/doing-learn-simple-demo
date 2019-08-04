package com.supertrampai.springbootsimplefilter.action;

import com.supertrampai.springbootsimplefilter.domain.Book;
import com.supertrampai.springbootsimplefilter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

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
