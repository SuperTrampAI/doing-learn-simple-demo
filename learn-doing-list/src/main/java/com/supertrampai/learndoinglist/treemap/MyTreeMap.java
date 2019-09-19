package com.supertrampai.learndoinglist.treemap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 18:30 2019/9/15
 * @Modified By:
 */
public class MyTreeMap {

    public static void main(String[] args) {

        /**
         * TreeMap是一个有序的集合，通过红黑树实现
         *
         */
        TreeMap<String,String> tmap=new TreeMap<>();

        tmap.put("1","");
        tmap.put("2","");
        tmap.put("3","");
        tmap.put("4","");
        tmap.put("5","");

        // 迭代方式
        Set<Map.Entry<String, String>> set =
                tmap.entrySet();
        for(Map.Entry<String,String> me : set) {
            System.out.println(me.getKey() + ": Rs."
                    + me.getValue());

        }

        for(Map.Entry<String,String> me : set) {
            System.out.println(me.getKey() + ": Rs."
                    + me.getValue());

        }

        // method
        //是否包含该key
        tmap.containsKey("1");
        //是否包含该value
        tmap.containsValue("");
        // 返回map中的第一个key
        tmap.firstKey();
        tmap.get("");
        tmap.lastKey();
        tmap.remove("");
        tmap.putAll(new TreeMap<>());
        tmap.entrySet();
        tmap.size();
        tmap.values();
        tmap.clone();
        tmap.headMap("");
        tmap.keySet();
        tmap.put("","");
        tmap.subMap("","");
        tmap.clear();






    }
}
