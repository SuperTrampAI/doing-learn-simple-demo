package com.supertrampai.lambdasimplelearn;

import com.supertrampai.lambdasimplelearn.domain.Man;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 15:16 2019/11/7
 * @Modified By:
 */
public class TestStream {

    public static void main(String[] args) {

        List<Man> mans=new ArrayList<>();

        mans.add(new Man("name1",12));
        mans.add(new Man("name2",45));
        mans.add(new Man("name3",30));

        Predicate<Man> pred=p->p.getAge()>35;

        displayPeople(mans, pred);

        Man[] mans2={new Man("name4",12),new Man("name5",22),new Man("name6",42)};

        for (int i=0;i<mans2.length;i++){
            System.out.println(mans2[i].toString());
        }

        //从一个基本类型或者符复合对象的数组转换成流对象，就可以进行lambda表达式，过滤，方法应用等功能。
        System.out.println("------------------方法1------------------------");
        Stream<Man> manStream =Stream.of(mans2);
        manStream.forEach(m->System.out.println(m.toString()));

        System.out.println("------------------方法2------------------------");
        Stream<Man> manStream1= Arrays.stream(mans2);
        //manStream1.forEach(man -> System.out.println(man.toString()));

        IntSummaryStatistics intSummaryStatistics= manStream1.mapToInt(x->x.getAge()).summaryStatistics();//
        System.out.println(intSummaryStatistics.getMax());

    }

    public static void displayPeople(List<Man> man,Predicate<Man> pred){

        System.out.println("Start:");
        /*man.forEach(m->{
            if(pred.test(m)){
                System.out.println(m.getName());
            }
        });*/
        man.parallelStream()// or stream()
                .filter(pred)// 使用filter方法过滤，传入的参数为过滤的条件
                .forEach(m->System.out.println(m.getName()));
    }

}
