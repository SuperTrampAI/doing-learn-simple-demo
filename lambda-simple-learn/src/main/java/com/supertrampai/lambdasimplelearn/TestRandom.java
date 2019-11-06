package com.supertrampai.lambdasimplelearn;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 17:08 2019/11/6
 * @Modified By:
 */
public class TestRandom {

    public static void main(String[] args) {
        Random random = new Random();
        //创建一个无穷尽的double类型的数字流
        DoubleStream doubleStream = random.doubles();
        //创建一个无穷尽的int类型的数字流
        IntStream intStream = random.ints(0, 100);

        System.out.println(doubleStream);
        System.out.println(intStream);

        intStream.limit(10).forEach(System.out::println);

        //创建100个随机数
        List<Integer> listInt= intStream.limit(100).boxed().collect(Collectors.toList());



    }

}
