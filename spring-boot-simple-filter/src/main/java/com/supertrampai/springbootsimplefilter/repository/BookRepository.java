package com.supertrampai.springbootsimplefilter.repository;

import com.supertrampai.springbootsimplefilter.domain.Book;
import com.supertrampai.springbootsimplefilter.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-02 14:28
 */
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByBname(String bname);
    Book findByBnameAndPrice(String bname, Integer price);


}