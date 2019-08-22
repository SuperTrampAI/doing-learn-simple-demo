package com.supertrampai.springbootsimpleexcel.repository;

import com.supertrampai.springbootsimpleexcel.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @author lxh800109@gmail.com
 * @create 2019-08-21 20:39
 */

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
