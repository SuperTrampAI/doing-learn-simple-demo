package com.supertrampai.guavasimplelearn;

import com.google.common.base.Objects;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 14:13 2019/11/19
 * @Modified By:
 */
public class ObjectsDemo {

    public static void main(String[] args) {

        //判断两个值
        System.out.println(Objects.equal("a",null));

        System.out.println(new People(1,"name1").toString());
        System.out.println(new People(1,"name1").hashCode());
        System.out.println(new People(1,"name2").hashCode());

        System.out.println(Objects.hashCode(new PeopleNew(1,"name1")));

    }

}
