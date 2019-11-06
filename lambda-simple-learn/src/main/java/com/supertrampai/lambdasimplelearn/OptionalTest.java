package com.supertrampai.lambdasimplelearn;

import java.util.Optional;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 15:55 2019/11/6
 * @Modified By:
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> name=Optional.of("name");

        Optional empty=Optional.ofNullable(null);
        if(name.isPresent()){
            System.out.println(name.get());
        }
        name.ifPresent(value->{
            System.out.println(value.length());
        });

        //如果name存在值，返回值。反之输出参数
        name.orElse("test");

        // 转换为大写
        Optional<String> upperName= name.map(value->value.toUpperCase());
        upperName=name.flatMap(value->Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("大写 name"));

        //过滤
        Optional<String> fileterName=name.filter(value->value.length()>6);
        System.out.println(fileterName.orElse("长度不足6"));
    }

}
