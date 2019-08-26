package com.supertrampai.springbootsimplemongodb.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private ObjectId id;
    private String name;
    private String password;
    private Integer age;
    private Integer sex;
    private String nickname;
    private Integer usertype;
    private Integer status;
    private Date  createdt;
    private Date updatedt;

    public User(String name, String password, Integer age, Integer sex, String nickname, Integer usertype) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.nickname = nickname;
        this.usertype = usertype;
    }
    public User(){}

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedt() {
        return createdt;
    }

    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    public Date getUpdatedt() {
        return updatedt;
    }

    public void setUpdatedt(Date updatedt) {
        this.updatedt = updatedt;
    }
}
