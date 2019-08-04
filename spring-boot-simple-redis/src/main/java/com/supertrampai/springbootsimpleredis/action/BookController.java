package com.supertrampai.springbootsimpleredis.action;

import com.supertrampai.springbootsimpleredis.domain.Book;
import com.supertrampai.springbootsimpleredis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cache.annotation.Cacheable;
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
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getBook")
    @Cacheable(value="book-keys")
    public Book getBook() {
        Book book=new Book(12313, "fggggggggggg", 1234, "ssssssssss");
        System.out.println("this没有出现，数据成功加载出来，则表示访问的是redis缓存");
        return book;
    }
    @RequestMapping("/bid")
    String uid(HttpSession session) {
        UUID bid = (UUID) session.getAttribute("bid");
        if (bid == null) {
            bid = UUID.randomUUID();
        }
        session.setAttribute("bid", bid);
        return session.getId();
    }
    @RequestMapping(value="/getBookId", method= RequestMethod.GET)
    @Cacheable(value = "get-books", key = "#bid")
    public Book getBookId(@RequestParam Integer bid){
        System.out.println("控制台没有出现该信息，则是访问的缓存");
        return bookService.queryById(bid);
    }

}

/*
* @Cacheable : 这个注解的作用为，在第一次访问完以后，不再第二次缓存，直接从缓存加载数据。
* @Cacheable(value = "get-books", key = "#id")
*
* */
