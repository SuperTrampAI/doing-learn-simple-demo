package com.supertrampai.jspservlet.dao;

import com.supertrampai.jspservlet.command.IDaoCommand;
import com.supertrampai.jspservlet.domain.Book;

import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:10 2019/9/18
 * @Modified By:
 */
public interface IBook extends IDaoCommand<Book> {

    /**
     * 查询所有的数据
     * @return
     */
    @Override
     List<Book> queryAllData();

    /**
     * 新增数据
     * @param t
     * @return
     */
    @Override
     int insertData(Book t);

    /**
     * 修改数据
     * @param t
     * @return
     */
    @Override
     int update(Book t);

    /**
     * 删除数据
     * @param id
     * @return
     */
    @Override
     int delete(int id);

    /**
     * 查询一条数据通过ID
     * @param id
     * @return
     */
    @Override
     Book queryDataById(int id);

}
