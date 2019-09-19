package com.supertrampai.jspservlet.command;

import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 10:29 2019/9/19
 * @Modified By:
 */
public interface IServiceCommand<T> {

    /**
     *  查询所有的数据
     */
    List<T> queryAllData();

    /**
     * 新增数据
     * @param t
     * @return
     */
     boolean insertData(T t);

    /**
     * 修改数据
     * @param t
     * @return
     */
     boolean update(T t);

    /**
     * 删除数据
     * @param id
     * @return
     */
     boolean delete(int id);

    /**
     * 查询一条数据通过ID
     * @param id
     * @return
     */
     T queryDataById(int id);


}
