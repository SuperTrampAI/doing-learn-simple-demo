package com.supertrampai.springbootsimpleswagger.domain;

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
    private Integer bid;

    @ApiModelProperty(notes = "The database generated book bname",example ="SuperTrampAI", required = true, position = 1)
    private String bname;

    @ApiModelProperty(notes = "The database generated book uid",example ="1", required = true, position = 2)
    private Integer uid;

    @ApiModelProperty(notes = "The database generated book publish",example ="publish", required = true, position = 3)
    private String publish;

    @ApiModelProperty(notes = "The database generated book publishdate",example ="2019-01-01", required = true, position = 4)
    private Date publishdate;

    @ApiModelProperty(notes = "The database generated book page",example ="88", required = true, position = 5)
    private Integer page;

    @ApiModelProperty(notes = "The database generated book price",example ="88", required = true, position = 6)
    private Integer price;

    @ApiModelProperty(notes = "The database generated book content",example ="超级符号就是超级创意", required = true, position = 7)
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
}
