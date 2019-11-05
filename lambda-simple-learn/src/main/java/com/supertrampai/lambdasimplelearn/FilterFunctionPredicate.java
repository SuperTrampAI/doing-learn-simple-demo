package com.supertrampai.lambdasimplelearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 10:33 2019/11/5
 * @Modified By:
 */
public class FilterFunctionPredicate {

    public static void main(String[] args) {
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (String str)->str.startsWith("J"));

        // 2
        testLambdaAndMethod(languages);

        String str="Hello World";

        // 需求：为每个价格添增加12%，并将增加后的输出在控制台
        List<Integer> costBeforeTax=Arrays.asList(100,200,300,400,500,100,300);
        for(Integer coat:costBeforeTax){
            // .12 是什么语法？
            Double c=coat+ .12*coat;
            System.out.println(c);
        }
        costBeforeTax.stream().map((cost)->cost+.12*cost).forEach(System.out::println);
        //-----------------------------------------------
        //使用lambda 增加百分之12后，求和并输出在控制台
        Double bill= costBeforeTax.stream().map((cost)->cost+.12*cost).reduce((sum,cost)->sum+cost).get();
        System.out.println(bill);
        // 过滤list
        List<String> strList=Arrays.asList("adsf","adsf324","ad","adsfsdf","a");
        List<String> filterList=strList.stream().filter((x)->x.length()>2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filterList);

        //对集合中的每一个数的平方以后去重
        List<Integer> distinct =costBeforeTax.stream().map(x->x*x).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", costBeforeTax, distinct);

        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String g7String=G7.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(g7String);

        //求平均值，和，最大，最小值
        IntSummaryStatistics intSummaryStatistics=costBeforeTax.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax()+"/"+intSummaryStatistics.getMin()+"/"+intSummaryStatistics.getAverage()+"/"+intSummaryStatistics.getSum());


    }

    // Predicate 如果不指定参数类型，在使用该方法时，无法使用子类的方法，如下
    //Predicate<? extends Object> b 这样时，无法使用String的方法

    /*public static void filter(List<String> names, Predicate<String> condition) {
        for(String name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }*/

    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }

    public static void testLambdaAndMethod(List names){
        Predicate<String> startWithJ=(n)->n.startsWith("J");
        Predicate<String> foueLetterLong=(n)->n.length()==4;
        names.stream().filter(startWithJ.and(foueLetterLong)).forEach((n)->System.out.println("test lambda and method::"+n));
    }

}
