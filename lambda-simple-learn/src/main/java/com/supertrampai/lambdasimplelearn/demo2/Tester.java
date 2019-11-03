package com.supertrampai.lambdasimplelearn.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 17:14 2019/10/30
 * @Modified By:
 */
public class Tester {

    public static void main(String[] args) {
        /**
         * FuncInter 接口中只能有一个方法，函数式接口使用：FunctionalInterface注解
         * 使用方式如下：(a,b)-> a+b
         *
         */
        FuncInter funcInter =(a,b)-> a+b ;
        System.out.println(funcInter.fun(1,2));
        //new Thread(()->System.out.println("sfd"));

        // list
        List features= Arrays.asList("java","c","c++","python","Go");
        //方式1
        for(Object str:features){
            System.out.println(str);
        }
        //方式2
        features.forEach(n->System.out.println(n));
        //方式3
        features.forEach(System.out::println);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sdf");
            }
        }).start();

        new Thread(()->System.out.println("sdfsdf")).start();


    }

    public static void filter(List names, Predicate condition) {
        /**
         * condition.test()  如果参数有内容，则继续
         */
        names.stream().filter((name) -> (condition.test(name)))
                .forEach((name) -> {System.out.println(name + " ");
                });
    }

}
