package com.supertrampai.springbootsimplemybatis.mapper;

import com.supertrampai.springbootsimplemybatis.domain.Book;

import java.util.List;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-11 12:51
 */
public interface BookMapperXML {

    List<Book> getAll();

    Book getOne(Integer bid);

    void insert(Book book);

    void insertList(List<Book> books);

    void update(Book book);

    void delete(Integer bid);

    //@Select("select * from user where ${column} = #{value}")
    //Book findByColumn(@Param("column") String column, @Param("value") String value);
    //如果数据库表中的字段和java对象的字段不一样，解决方法之一是：在sql从用“as” 来进行转换


}
