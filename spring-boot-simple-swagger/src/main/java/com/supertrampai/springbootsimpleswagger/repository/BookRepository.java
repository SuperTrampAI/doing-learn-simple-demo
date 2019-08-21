package com.supertrampai.springbootsimpleswagger.repository;

import com.supertrampai.springbootsimpleswagger.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-21 20:39
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
}
