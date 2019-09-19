package com.supertrampai.jspservlet.command;

import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 14:35 2019/9/18
 * @Modified By:
 */
public interface IDaoCommand<T> {

    /**
     * 查询所有的数据
     * @return
     */
    List<T> queryAllData();

    /**
     * 新增数据
     * @param t
     * @return
     */
     int insertData(T t);

    /**
     * 修改数据
     * @param t
     * @return
     */
     int update(T t);

    /**
     * 删除数据
     * @param id
     * @return
     */
     int delete(int id);

    /**
     * 查询一条数据通过ID
     * @param id
     * @return
     */
     T queryDataById(int id);

}
