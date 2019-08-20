package com.supertrampai.springbootsimplecache.repository;

import com.supertrampai.springbootsimplecache.domain.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/20 21:12
 */
@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    @CacheEvict(value="books", allEntries=true)
    public Book getByIsbn2(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    @CachePut(value="books")
    public Book getByIsbn3(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }
    @CachePut(value="books", condition="#book.title=='bookname'")
    public String getAddress(Book book) {
        return null;
    }
    //根据方法的输出而不是输入来控制缓存- 通过unless参数

    @CachePut(value="books", unless="#result.length()<64")
    public String getAddress1(Book book) {return null;}




    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
