package com.supertrampai.jucsimplelearn;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 9:39 2019/11/11
 * @Modified By:
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap m=new ConcurrentHashMap();

        m.put(100, "Hello");
        m.put(101, "Geeks");
        m.put(102, "Geeks");

        m.putIfAbsent(101, "Hello");

        m.remove(101, "Geeks");

        m.putIfAbsent(103, "Hello");

        m.replace(101, "Hello", "For");
        System.out.println(m);

    }

}
