package com.supertrampai.lambdasimplelearn;

import com.supertrampai.lambdasimplelearn.domain.Man;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 9:27 2019/11/6
 * @Modified By:
 */
public class LambdaSortList {

    public static void main(String[] args) {
        List<Man> mans = Arrays.asList(new Man("Sarah", 10), new Man("Jack", 12), new Man("Aack", 20), new Man("Sarah", 20));
        // 排序1：Man.sortByName(mans);
        // 排序2： Collections.sort(mans,Comparator.comparing(Man::getName));
        // 排序三
        /*mans.sort((m1,m2)->{
            if(m1.getName().equals(m2.getName())){
                return m1.getAge()-m2.getAge();
            }else{
                return m1.getName().compareTo(m2.getName());
            }
        });*/
        // 排序4
        mans.sort(Comparator.comparing(Man::getAge).thenComparing(Man::getName));
        for(Man man:mans){
            System.out.println(man.getName()+":"+man.getAge());
        }



    }
    public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {

    }

}
