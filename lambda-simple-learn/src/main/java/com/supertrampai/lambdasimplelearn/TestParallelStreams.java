package com.supertrampai.lambdasimplelearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:44 2019/11/7
 * @Modified By:
 */
public class TestParallelStreams {

    public static void main(String[] args) {

        System.out.println("Createing list");
        List<String> list=new ArrayList<>();
        for(int i=0;i<100000;i++){
            list.add("Item："+i);
        }

        list.stream()
                //.parallel()
                .forEach(System.out::println);

        long count=list.stream().parallel().count();
        System.out.println(count);
    }

}
