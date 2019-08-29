package com.supertrampai.springbootsimplewebfluxthymeleafserver;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 23:49 2019/8/29
 * @Modified By:
 */
public class Book {

    private String name;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Book(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Book() { }
}
