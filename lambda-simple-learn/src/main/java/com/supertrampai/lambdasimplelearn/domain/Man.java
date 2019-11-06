package com.supertrampai.lambdasimplelearn.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 9:27 2019/11/6
 * @Modified By:
 */
public class Man {

    private String name;
    private Integer age;

    public Man(){
        super();
    }

    public Man(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void sortByName(List mans){
        Collections.sort(mans, new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}
