package com.supertrampai.guavasimplelearn;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:19 2019/11/20
 * @Modified By:
 */
public class MultisetDemo {

    //    guava新增的集合
    //    Multiset
    //　　SortedMultiset
    //　　Multimap
    //　　ListMultimap
    //　　SetMultimap
    //　　BiMap
    //　　ClassToInstanceMap
    //　　Table

    public static void main(String[] args) {
        testMultsetWordCount();
    }

    public static void testMultsetWordCount(){
        String strWorld="wer|dfd|dd|dfd|dda|de|dr|dd";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        // 可以使用*.create()；方法创建其他集合
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }

        System.out.println("所以的元素个数:"+wordsMultiset.size());
        System.out.println("指定元素的个数:"+wordsMultiset.count("dd"));
        System.out.println("改变前指定元素的个数:"+wordsMultiset.setCount("dd",3)+",改变后指定元素的个数:"+wordsMultiset.count("dd"));
        System.out.println("删除前指定元素的个数:"+wordsMultiset.remove("dd")+",删除后指定元素的个数:"+wordsMultiset.count("dd"));//只删除1
    }
}
