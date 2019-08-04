package com.supertrampai.springbootsimplejpa.repository;

import com.supertrampai.springbootsimplejpa.domain.Book;
import com.supertrampai.springbootsimplejpa.domain.Book;
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

    /**
     * @Description 主要语法： findByXX,readByXX,queryByXX,countByXX, getByXX, And, Or,LIKE, IgnoreCase, OrderBy
     *
     * @param bname
     * @return
     */
    List<Book> findByBname(String bname);

    /**
     * where x.bname = ?1 and x.price = ?2
     * @param bname
     * @param price
     * @return
     */
    List<Book> findByBnameAndPrice(String bname, Integer price);

    /**
     * where x.bname = ?1 or x.price = ?2
     * @param bname
     * @param price
     * @return
     */
    List<Book> findByBnameOrPrice(String bname, Integer price);

    /**
     * count
     * @param bname
     * @return
     */
    Long countBookByBname(String bname);

    /**
     * 查找bname，并排序
     * @param bname
     * @return
     */
    List<Book> findByBnameOrderByBnameDesc(String bname);

    /**
     * 位于startDate和endDate之间的
     * where x.startDate between ?1 and ?2
     * @param startDate
     * @param endDate
     * @return
     */
    List<Book> findByPublishdateBetween(Date startDate,Date endDate);

    /**
     * 小于price
     * where x.price < ?1
     * @param price
     * @return
     */
    List<Book> findByPriceLessThan(Integer price);

    /**
     * where x.price ⇐ ?1
     * @param price
     * @return
     */
    List<Book> findByPriceLessThanEqual(Integer price);

    /**
     * where x.price > ?1
     * @param price
     * @return
     */
    List<Book> findByPriceGreaterThan(Integer price);

    /**
     * where x.price >= ?1
     * @param price
     * @return
     */
    List<Book> findByPriceGreaterThanEqual(Integer price);

    /**
     * where x.date > ?1
     * @param date
     * @return
     */
    List<Book> findByPublishdateAfter(Date date);

    /**
     * where x.date < ?1
     * @param date
     * @return
     */
    List<Book> findByPublishdateBefore(Date date);

    /**
     * where x.age is null
     * @return
     */
    List<Book> findByBnameIsNull();

    /**
     * where x.age not null
     * @return
     */
    List<Book> findByBnameIsNotNull();

    /**
     * where x.bname like ?1
     * @param bname
     * @return
     */
    List<Book> findByBnameLike(String bname);

    /**
     * where x.bname not like ?1
     * @return
     */
    List<Book> findByBnameNotLike(String bname);

    /**
     * where x.bname <> ?1
     * @param bname
     * @return
     */
    List<Book> findByBnameNot(String bname);

    /**
     * where x.bname in ?1
     * @param bname
     * @return
     */
    List<Book> findByBnameIn(String bname);

    /**
     * where x.bname not in ?1
     * @param bname
     * @return
     */
    List<Book> findByBnameNotIn(String bname);

    /**
     * where x.active = true
     * @return
     */
    //List<Book> findByBbooleanTRUE();

    /**
     * where x.active = false
     * @return
     */
    //List<Book> findByBbooleanFALSE();

    Book findFirstByBnameOrderByBnameAsc(String bname);

    Book findTop1ByPriceOrderByPriceDesc(Integer price);

    Page<Book> queryFirst10ByBname(String lastname, Pageable pageable);
    List<Book> findFirst10ByBname(String lastname, Sort sort);
    List<Book> findTop10ByBname(String lastname, Pageable pageable);

    @Modifying
    @Query("update Book b set b.bname = ?1 where b.bid = ?2")
    int modifyByBId(String  bname, Long bid);

    @Transactional
    @Modifying
    @Query("delete from Book where bid = ?1")
    void deleteByBId(Integer bid);

    @Transactional(timeout = 10)
    @Query("select b from Book b where b.bname = ?1")
    Book findByBnames(String bname);

    /**
     * @Transactional 事务
     *
     */
}