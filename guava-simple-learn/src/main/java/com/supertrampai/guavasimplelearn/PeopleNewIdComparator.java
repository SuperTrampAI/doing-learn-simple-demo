package com.supertrampai.guavasimplelearn;

import com.google.common.primitives.Ints;

import java.util.Comparator;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description: 自定义排序：按照id排序
 * @Date: Created in 13:45 2019/11/20
 * @Modified By:
 */
public class PeopleNewIdComparator implements Comparator<PeopleNew> {

    @Override
    public int compare(PeopleNew o1, PeopleNew o2) {
        return Ints.compare(o1.getAge(),o2.getAge());
    }
}
