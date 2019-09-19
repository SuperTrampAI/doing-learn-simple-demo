package com.supertrampai.jspservlet.dao.impl;

import com.supertrampai.jspservlet.dao.IBook;
import com.supertrampai.jspservlet.domain.Book;
import com.supertrampai.jspservlet.util.MySqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:48 2019/9/18
 * @Modified By:
 */
public class BookImpl implements IBook {

    public Connection conn1 = null;
    public ResultSet rs = null;
    public PreparedStatement ps = null;

    @Override
    public List<Book> queryAllData() {
        // 链接数据库
        conn1 = MySqlUtil.getConnection();
        List<Book> list = new ArrayList<Book>();
        try {
            // 查询多条数据
            String sqlSelect = "select * from book ";
            ps = conn1.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            Book book = null;
            while (rs.next()) {

                book = new Book();
                book.setBid(rs.getInt("bid"));
                book.setBname(rs.getString("bname"));
                book.setUid(rs.getString("uid"));
                book.setPublish(rs.getString("publish"));
                book.setPublishdate(rs.getDate("publishdate"));
                book.setPage(rs.getInt("page"));
                book.setPrice(rs.getInt("price"));
                book.setContent(rs.getString("content"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(rs, ps, conn1);
        }
        return list;

    }

    @Override
    public int insertData(Book t) {
        conn1 = MySqlUtil.getConnection();
        int i = 0;
        try {
            String sqlInsert = "insert into book(bname,uid,publish,publishdate,page,price,content) values(?,?,?,?,?,?,?) ;";
            ps = conn1.prepareStatement(sqlInsert,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            // 这里的1,2..必须要按上面的新增的顺序来定义
            ps.setString(1, t.getBname());
            ps.setString(2, t.getUid());
            ps.setString(3, t.getPublish());
            ps.setDate(4, new java.sql.Date(t.getPublishdate().getTime()));
            ps.setInt(5, t.getPage());
            ps.setInt(6, t.getPrice());
            ps.setString(7, t.getContent());
            ps.executeUpdate();
            // 得到 最新的 ID
            rs = ps.getGeneratedKeys();
            // 是否存在
            if (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(rs, ps, conn1);
        }
        return i;
    }

    @Override
    public int update(Book t) {
        conn1 = MySqlUtil.getConnection();
        int i = 0;
        // bname,uid,publish,publishdate,page,price,content
        try {
            String sqlUpdate = "update book set bname=?, uid =? ,publish=?,publishdate=?,page=?,price=?,content=?  where bid=?";
            ps = conn1.prepareStatement(sqlUpdate);
            ps.setString(1, t.getBname());
            ps.setString(2, t.getUid());
            ps.setString(3, t.getPublish());
            ps.setDate(4, new java.sql.Date(t.getPublishdate().getTime()));
            ps.setInt(5, t.getPage());
            ps.setInt(6, t.getPrice());
            ps.setString(7, t.getContent());
            ps.setInt(8,t.getBid());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(null, ps, conn1);
        }
        return i;
    }

    @Override
    public int delete(int id) {
        conn1 = MySqlUtil.getConnection();
        int i = 0;
        try {
            String sqlDelete = "delete from book where bid=?";
            ps = conn1.prepareStatement(sqlDelete);
            ps.setInt(1, id);
            i = ps.executeUpdate();
            if (i == 1) {
                return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(null, ps, conn1);
        }
        return i;
    }

    @Override
    public Book queryDataById(int id) {
        conn1 = MySqlUtil.getConnection();
        String sql = "select * from book where bid=?";
        Book book = null;
        if (id > 0) {
            try {
                ps = conn1.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    book = new Book();
                    book.setBid(rs.getInt("bid"));
                    book.setBname(rs.getString("bname"));
                    book.setUid(rs.getString("uid"));
                    book.setPublish(rs.getString("publish"));
                    book.setPublishdate(rs.getDate("publishdate"));
                    book.setPage(rs.getInt("page"));
                    book.setPrice(rs.getInt("price"));
                    book.setContent(rs.getString("content"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                MySqlUtil.close(null, ps, conn1);
            }
        }
        return book;
    }
}
