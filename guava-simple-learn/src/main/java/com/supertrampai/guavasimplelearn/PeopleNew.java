package com.supertrampai.guavasimplelearn;

import java.util.Objects;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:48 2019/11/19
 * @Modified By:
 */
public class PeopleNew {

    private Integer age;
    private String name;


    public PeopleNew(){}

    public PeopleNew(Integer age,String name){
        this.age=age;
        this.name=name;
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
}
