package com.supertrampai.basedemo.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @Description
 * @author lxh800109@gmail.com
 * @create 2019-08-01 17:28
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;

    @GeneratedValue
    private String bname;

    @GeneratedValue
    private Integer uid;

    @GeneratedValue
    private String publish;

    @GeneratedValue
    private Date publishdate;

    @GeneratedValue
    private Integer page;

    @GeneratedValue
    private Integer price;

    @GeneratedValue
    private String content;

    public Book(Integer bid, String bname, Integer uid, String publish, Date publishdate, Integer page, Integer price, String content) {
        this.bid = bid;
        this.bname = bname;
        this.uid = uid;
        this.publish = publish;
        this.publishdate = publishdate;
        this.page = page;
        this.price = price;
        this.content = content;
    }

    public Book(String bname, Integer uid, String publish, Date publishdate, Integer page, Integer price, String content) {
        this.bname = bname;
        this.uid = uid;
        this.publish = publish;
        this.publishdate = publishdate;
        this.page = page;
        this.price = price;
        this.content = content;
    }

    public Book(Integer bid, String bname, Integer uid, String publish) {
        this.bid = bid;
        this.bname = bname;
        this.uid = uid;
        this.publish = publish;
    }

    public Book() {
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
