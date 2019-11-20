package com.supertrampai.guavasimplelearn;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import javafx.concurrent.Worker;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.core.annotation.Order;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 17:23 2019/11/19
 * @Modified By:
 */
public class OrderingDemo {

    public static void main(String[] args) {

        //使用如下方法创建排序器
        // 1 对可排序类型做自然排序，如数字按大小，日期按先后排序
        Ordering ordering = Ordering.natural();
        // 2. 按对象的字符串形式做字典排序[lexicographical ordering]
        Ordering ordering1 = Ordering.usingToString();
        // 3. 把给定的Comparator转化为排序器
        Ordering ordering2 = Ordering.from(new Comparator<PeopleNew>() {
            @Override
            public int compare(PeopleNew o1, PeopleNew o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        Ordering<String> byLengthOrdering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

        List<PeopleNew> peopleNewList=new ArrayList<PeopleNew>();

        PeopleNew peopleNew1=new PeopleNew(23,"name1");
        PeopleNew peopleNew2=new PeopleNew(13,"name2");
        PeopleNew peopleNew3=new PeopleNew(43,"name3");
        peopleNewList.add(peopleNew1);
        peopleNewList.add(peopleNew2);
        peopleNewList.add(peopleNew3);

        //在调用natural排序以后，调用reverse，则按照规则反向排序
        Ordering<PeopleNew>    peopleNewOrdering=Ordering.usingToString().reverse().onResultOf(new Function<PeopleNew, Comparable>() {
            @Nullable
            @Override
            public Comparable apply(@Nullable PeopleNew peopleNew) {
                return peopleNew.getAge();
            }
        });


        System.out.println("------------");
        for (PeopleNew peopleNew:peopleNewOrdering.sortedCopy(peopleNewList)){
            System.out.println(peopleNew.toString());
        }

        // ------------------------------------------
        List<Integer>  integers= Arrays.asList(1,5,8,9,2,3,1,7);
        // nullsFirst() 把null排在最前面
        Collections.sort(integers,Ordering.natural().nullsFirst());
        for (int i=0;i<integers.size();i++){
            System.out.println(integers.get(i));
        }

        System.out.println("最大值："+Ordering.natural().max(integers));
        System.out.println("最大的前N个值："+ Ordering.natural().greatestOf(integers,3).toString());

        List<String> stringList=Lists.newArrayList("main","test","b","A");
        Collections.sort(stringList,Ordering.usingToString());
        for (String string:stringList){
            System.out.println(string);
        }

        //List<PeopleNew> peopleNews = Lists.newArrayList(peopleNew1, peopleNew2, peopleNew3);
        //Ordering<PeopleNew> orderWorker = Ordering.from(new PeopleNewIdComparator());
        //Collections.sort(peopleNews, orderWorker);

    }

}
