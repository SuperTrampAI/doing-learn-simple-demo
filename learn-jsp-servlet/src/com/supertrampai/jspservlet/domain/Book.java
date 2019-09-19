package com.supertrampai.jspservlet.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @Description
 * @author lxh800109@gmail.com
 * @create 2019-08-01 17:28
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 4599919884161123706L;

    private Integer bid;
    private String bname;
    private String uid;
    private String publish;

    private Date publishdate;
    private Integer page;
    private Integer price;
    private String content;

    public Book(Integer bid, String bname, String uid, String publish, Date publishdate, Integer page, Integer price, String content) {
        this.bid = bid;
        this.bname = bname;
        this.uid = uid;
        this.publish = publish;
        this.publishdate = publishdate;
        this.page = page;
        this.price = price;
        this.content = content;
    }

    public Book(Integer bid, String bname, String uid, String publish) {
        this.bid = bid;
        this.bname = bname;
        this.uid = uid;
        this.publish = publish;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", uid=" + uid +
                ", publish='" + publish + '\'' +
                ", publishdate=" + publishdate +
                ", page=" + page +
                ", price=" + price +
                ", content='" + content + '\'' +
                '}';
    }
    /**
     * @Transient  不需要和数据库映射的属性
     */

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
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
