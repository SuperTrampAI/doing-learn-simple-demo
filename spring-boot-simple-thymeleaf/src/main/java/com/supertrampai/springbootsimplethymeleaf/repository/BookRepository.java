package com.supertrampai.springbootsimplethymeleaf.repository;

import com.supertrampai.springbootsimplethymeleaf.domain.Book;
import com.supertrampai.springbootsimplethymeleaf.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-02 14:28
 */
public interface BookRepository extends JpaRepository<Book,Integer> {



}