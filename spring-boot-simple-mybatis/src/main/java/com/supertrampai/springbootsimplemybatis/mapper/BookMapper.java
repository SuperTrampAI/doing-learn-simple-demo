package com.supertrampai.springbootsimplemybatis.mapper;

import com.supertrampai.springbootsimplemybatis.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-11 12:30
 */
public interface BookMapper {

    @Select("SELECT * FROM book")
    @Results({
            @Result(property = "bid",  column = "bid"),
            @Result(property = "bname", column = "bname")
    })
    List<Book> getAll();

    @Select("SELECT * FROM book WHERE bid = #{bid}")
    @Results({
            @Result(property = "bid",  column = "bid"),
            @Result(property = "bname", column = "bname")
    })
    Book getOne(Integer bid);

    @Insert("INSERT INTO book(bname,uid,publish) VALUES(#{bname}, #{uid}, #{publish})")
    void insert(Book book);

    @Update("UPDATE book SET bname=#{bname},uid=#{uid} WHERE bid =#{bid}")
    void update(Book book);

    @Delete("DELETE FROM book WHERE bid =#{bid}")
    void delete(Integer bid);

    //#{} ${}
    // This example creates a prepared statement, something like select * from teacher where name = ?;
    //@Select("Select * from teacher where name = #{name}")
    //Teacher selectTeachForGivenName(@Param("name") String name);

    // This example creates n inlined statement, something like select * from teacher where name = 'someName';
    //@Select("Select * from teacher where name = '${name}'")
    //Teacher selectTeachForGivenName(@Param("name") String name);
}
