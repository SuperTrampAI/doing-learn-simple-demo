package com.supertrampai.springbootsimplejpa.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/04 17:38
 */
@Data
public class BookInputDto implements Serializable {
    private static final long serialVersionUID = -6922051572907718016L;

    private int pageNum=1;
    private int pageSize=10;
}
