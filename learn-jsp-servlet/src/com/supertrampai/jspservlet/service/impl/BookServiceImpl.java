package com.supertrampai.jspservlet.service.impl;

import com.supertrampai.jspservlet.dao.IBook;
import com.supertrampai.jspservlet.dao.impl.BookImpl;
import com.supertrampai.jspservlet.domain.Book;
import com.supertrampai.jspservlet.service.IBookService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 10:32 2019/9/19
 * @Modified By:
 */
public class BookServiceImpl implements IBookService {
    public Connection conn1 = null;
    public ResultSet rs = null;
    public PreparedStatement ps = null;
    boolean b=false;

    /**
     * 创建了 dao层的ITb_UserImp对象
     * 这里的 service层要想玉 dao层(BAL层逻辑层)建立联系那么必须要 创建  dao层的对象
     */
    IBook iBook=new BookImpl();



    @Override
    public List<Book> queryAllData() {
        return iBook.queryAllData();
    }

    @Override
    public boolean insertData(Book book) {
        if (book!=null) {  iBook.insertData(book);
            b=true;
        }
        return b;
    }

    @Override
    public boolean update(Book book) {
        if (book!=null) {
            iBook.update(book);
            b=true;
        }
        return b;
    }

    @Override
    public boolean delete(int id) {
        if (id!=0) {
            iBook.delete(id);
            b=true;
        }
        return b;
    }

    @Override
    public Book queryDataById(int id) {
        if (id!=0) {
            return iBook.queryDataById(id);
        }
        else {
            return null;
        }
    }
}
