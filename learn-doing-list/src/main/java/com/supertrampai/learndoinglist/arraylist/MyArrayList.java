package com.supertrampai.learndoinglist.arraylist;

import java.awt.print.Book;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 13:57 2019/9/14
 * @Modified By:
 */
public class MyArrayList {

    public static void main(String[] args) {
        //非线程安全
        ArrayList<String> bookNames=new ArrayList<>();
        //线程安全
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        /**
         * DOC
         * arraylist是一个动态数组：跟随数组的大小动态的改变数组的大小。在新增时，在原有的基础上，进行1.5倍的扩容；在删除数据时，进行相应的缩小
         * 对数据允许重复和空值，是一个有序的集合，维护数据插入的循序。
         * 访问速度快
         * 非线程安全
         * 适合顺序添加，随机访问的场景
         *
         *
         */

        // arraylist使用
        bookNames.add("name1");
        bookNames.add("name2");
        bookNames.add("name3");

        System.out.println(bookNames);

        // 在指定下标插入元素
        bookNames.add(0,"name0");

        System.out.println(bookNames);

        bookNames.add(bookNames.size(),"name4");
        System.out.println(bookNames);

        ArrayList<Object> nextBookNames=new ArrayList<Object>();
        nextBookNames.add("name5");
        nextBookNames.add("name6");
        nextBookNames.add("name7");

        // 把一个集合追加到另一个机会后面
        nextBookNames.addAll(bookNames);

        System.out.println(nextBookNames);

        ArrayList<String> test=new ArrayList<>();
        // isEmpty() 是否为空  如果为空，返回true。
        System.out.println(test.isEmpty());

        System.out.println(bookNames.size());

        System.out.println(bookNames.get(1));
        System.out.println(bookNames.set(2,"?"));

        // 删除
        bookNames.remove(2);
        List<String> a=new ArrayList<>();

        a.add("name");
        a.add("name6");
        a.add("name7");

        // 删除a集合中的数据
        nextBookNames.removeAll(a);
        System.out.println(nextBookNames);

        // 迭代方式
        List<String> tvShows = new ArrayList<>();
        tvShows.add("Breaking Bad");
        tvShows.add("Game Of Thrones");
        tvShows.add("Friends");
        tvShows.add("Prison break");

        System.out.println("=== Iterate using Java 8 forEach and lambda ===");
        tvShows.forEach(tvShow -> {
            System.out.println(tvShow);
        });

        System.out.println("\n=== Iterate using an iterator() ===");
        Iterator<String> tvShowIterator = tvShows.iterator();
        while (tvShowIterator.hasNext()) {
            String tvShow = tvShowIterator.next();
            System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using an iterator() and Java 8 forEachRemaining() method ===");
        tvShowIterator = tvShows.iterator();
        tvShowIterator.forEachRemaining(tvShow -> {
            System.out.println(tvShow);
        });

        System.out.println("\n=== Iterate using a listIterator() to traverse in both directions ===");
        // Here, we start from the end of the list and traverse backwards.
        ListIterator<String> tvShowListIterator = tvShows.listIterator(tvShows.size());
        while (tvShowListIterator.hasPrevious()) {
            String tvShow = tvShowListIterator.previous();
            System.out.println(tvShow);


        }

        System.out.println("\n=== Iterate using simple for-each loop ===");
        for(String tvShow: tvShows) {
            System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using for loop with index ===");
        for(int i = 0; i < tvShows.size(); i++) {
            System.out.println(tvShows.get(i));
        }

        //是否包含该元素
        System.out.println("Does names array contain \"Bob\"? : " + bookNames.contains("Bob"));

        // 返回第一次出现的下标
        bookNames.indexOf("name1");

        // 返回最后一次出现的下标
        bookNames.lastIndexOf("name1");

        // 排序
        //1：排序方式1
        Collections.sort(bookNames);
        //2：排序方式2
        bookNames.sort((book1, book2) -> book1.compareTo(book2));
        bookNames.sort(Comparator.naturalOrder());

        // 同步arratlist

        //清空 将内部的所有元素赋予null
        bookNames.clear();
        nextBookNames.clear();




        //  arraylist和vector对比  都是基于数组实现
        // vector 是arraylist的安全版本，大部分的方法一样




    }

}
