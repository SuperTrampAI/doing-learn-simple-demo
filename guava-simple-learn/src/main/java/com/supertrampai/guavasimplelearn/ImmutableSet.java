package com.supertrampai.guavasimplelearn;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 14:52 2019/11/20
 * @Modified By:
 */
public class ImmutableSet {

    //创建集合的方式
    // 使用of方法
    public static final ImmutableList immutableList=ImmutableList.of("name1","name2","name3","name4");

    public static void main(String[] args) {

        //List<String> list= Arrays.asList("name5","name6","name7","name8");
        List<String> stringList=new ArrayList<>();
        stringList.add("name1");
        stringList.add("name2");
        stringList.add("name3");
        stringList.add("name1");
        // 使用copyOf创建
        ImmutableList immutableList1 = ImmutableList.copyOf(stringList);
        System.out.println(immutableList1);

        //使用build方法
        PeopleNew peopleNew1=new PeopleNew(23,"name1");
        PeopleNew peopleNew2=new PeopleNew(13,"name2");
        PeopleNew peopleNew3=new PeopleNew(43,"name3");
        ImmutableList immutableList2 =ImmutableList.builder().add(peopleNew1).add(peopleNew2).add(peopleNew3).build();
        System.out.println(immutableList2);
    }

}
