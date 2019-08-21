package com.supertrampai.springbootsimplecache.repository;

import com.supertrampai.springbootsimplecache.MyCacheable;
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
    @Cacheable({"books","bookdss"})
    public Book getByIsbn21(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }
    // 使用key自定义cache的key
    @Cacheable(value="books", key="#id")
    public Book find(Integer id) {
        return null;
    }
    // 使用p0
    @Cacheable(value="books", key="#p0")
    public Book find2(Integer id) {
        return null;
    }

    /**
     * 当为true时表示进行缓存处理；当为false时表示不进行缓存处理
     * 下示例表示只有当user的id为偶数时才会进行缓存
     * @param book
     * @return
     */
    @Cacheable(value={"books"}, key="#user.id", condition="#book.id%2==0")
    public Book find(Book book) {
        System.out.println("find user by user " + book);
        return book;
    }

    /**
     * 标注在需要清除缓存元素的方法或类上的
     * allEntries属性：表示是否需要清除缓存中的所有元素
     * beforeInvocation属性：定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
     * @param isbn
     * @return
     */
    @CacheEvict(value="books", allEntries=true)
    public Book getByIsbn2(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    /**
     * 在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
     * @param isbn
     * @return
     */
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

    // 自定义注解
    @MyCacheable()
    public Book find3(Integer id) {
        return null;
    }

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
