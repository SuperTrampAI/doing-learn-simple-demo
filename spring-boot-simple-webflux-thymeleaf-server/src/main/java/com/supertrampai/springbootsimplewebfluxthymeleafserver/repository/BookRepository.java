package com.supertrampai.springbootsimplewebfluxthymeleafserver.repository;

import com.supertrampai.springbootsimplewebfluxthymeleafserver.Book;
import reactor.core.publisher.Flux;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 23:48 2019/8/29
 * @Modified By:
 */
public interface BookRepository {

    Flux<Book> findAll();

}
