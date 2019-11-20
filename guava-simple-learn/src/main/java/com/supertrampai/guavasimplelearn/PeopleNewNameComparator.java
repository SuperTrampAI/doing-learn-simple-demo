package com.supertrampai.guavasimplelearn;

import java.util.Comparator;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description: 自定义排序器：按照名字排序
 * @Date: Created in 13:25 2019/11/20
 * @Modified By:
 */
public class PeopleNewNameComparator implements Comparator<PeopleNew> {
    @Override
    public int compare(PeopleNew o1, PeopleNew o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
