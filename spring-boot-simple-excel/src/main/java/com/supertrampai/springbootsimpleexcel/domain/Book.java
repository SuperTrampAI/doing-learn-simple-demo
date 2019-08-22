package com.supertrampai.springbootsimpleexcel.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.supertrampai.springbootsimpleexcel.util.ExclUtile.ExcelAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
@ApiModel(description = "All details about the Book. ")
public class Book implements Serializable {

    private static final long serialVersionUID = 4599919884161123706L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated book bid",example ="1", required = true, position = 0)
    @ExcelAnnotation(id = 1, name = { "bid" }, width = 5000)
    //@JsonProperty("BID")
    private Integer bid;

    @ApiModelProperty(notes = "The database generated book bname",example ="SuperTrampAI", required = true, position = 1)
    @ExcelAnnotation(id = 2, name = { "bname" }, width = 5000)
    //@JsonProperty("BNAME")
    private String bname;

    @ApiModelProperty(notes = "The database generated book uid",example ="1", required = true, position = 2)
    @ExcelAnnotation(id = 3, name = { "uid" }, width = 5000)
    //@JsonProperty("UID")
    private Integer uid;

    @ApiModelProperty(notes = "The database generated book publish",example ="publish", required = true, position = 3)
    @ExcelAnnotation(id = 4, name = { "publish" }, width = 5000)
    @JsonProperty("PUBLIST")
    private String publish;

    @ApiModelProperty(notes = "The database generated book publishdate",example ="2019-01-01", required = true, position = 4)
    @ExcelAnnotation(id = 5, name = { "publishdate" }, width = 5000)
    //@JsonProperty("PUBLISHDATE")
    private Date publishdate;

    @ApiModelProperty(notes = "The database generated book page",example ="88", required = true, position = 5)
    @ExcelAnnotation(id = 6, name = { "page" }, width = 5000)
    //@JsonProperty("PAGE")
    private Integer page;

    @ApiModelProperty(notes = "The database generated book price",example ="88", required = true, position = 6)
    @ExcelAnnotation(id = 7, name = { "price" }, width = 5000)
    //@JsonProperty("PRICE")
    private Integer price;

    @ApiModelProperty(notes = "The database generated book content",example ="超级符号就是超级创意", required = true, position = 7)
    @ExcelAnnotation(id = 8, name = { "content" }, width = 5000)
    //@JsonProperty("CONTENT")
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

    public Book(Integer bid, String bname, Integer uid, String publish) {
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
