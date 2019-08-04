package com.supertrampai.springbootsimpleredis.service;

import com.supertrampai.springbootsimpleredis.CusException;
import com.supertrampai.springbootsimpleredis.domain.Book;
import com.supertrampai.springbootsimpleredis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/02 14:43
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book){
        bookRepository.save(book);
    }
    public void deleteById(Integer bid){
        bookRepository.deleteById(bid);
    }
    public Book queryById(Integer bid){
        return bookRepository.findById(bid).orElseThrow(()->new CusException("该数据不存在"));
    }


}
