package com.supertrampai.springbootsimplecache.repository;

import com.supertrampai.springbootsimplecache.domain.Book;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-20 21:06
 */
public interface BookRepository {

    Book getByIsbn(String isbn);

}
