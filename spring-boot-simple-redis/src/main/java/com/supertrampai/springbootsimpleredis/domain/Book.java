package com.supertrampai.springbootsimpleredis.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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
public class Book implements Serializable {

    private static final long serialVersionUID = 4599919884161123706L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;
    private String bname;
    private Integer uid;
    private String publish;
    private Date publishdate;
    private Integer page;
    private Integer price;
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
}
