package com.supertrampai.basedemo.repository;

import com.supertrampai.basedemo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-02 11:33
 */
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByBname(String bname);
    Book findByBnameAndPrice(String bname, Integer price);

}
