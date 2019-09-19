package com.supertrampai.jspservlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 14:20 2019/9/18
 * @Modified By:
 */
public class MySqlUtil {

    /**
     * 链接的mysql
     */
    private static final  String URL="jdbc:mysql://localhost:3306/fantastic-funicular?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";
    private static final String DREIVER = "com.mysql.jdbc.Driver";


    static {
        try {
            //加载驱动器
            Class.forName(DREIVER);

                /* 还有另一种方法,但是会加载驱动二次,通常不使用该方法
                try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            //创建与数据库的链接
            return  DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param rs
     * @param ps
     * @param conn
     * 设置一个公共的关闭链接、释放资源的方法    .   因为每次只要进行了增,删,查,改 之后 都必须要关闭事件,  那么就设置一个公共的方法
     * 而关闭资源要从 ResultSet先关闭-->,再到 PreparedStatement-->,最后到 Connection关闭
     */
    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
