package com.supertrampai.learndoinglist.hashmap;

import java.util.*;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 17:16 2019/9/15
 * @Modified By:
 */
public class MyHashMap {

    public static void main(String[] args) {
        HashMap<String, String> hmap = new HashMap<String, String>();
        Hashtable<String,String> htabl=new Hashtable<String,String>();

        Map<String,String> map= Collections.synchronizedMap(new HashMap<String,String >());

        Collections.synchronizedMap(new HashMap<String,String>());
        Collections.synchronizedMap(new HashMap<>());
        hmap.put(null,"sdf");
        // hashmap可以使用null作为key
        System.out.println(hmap.get(null));

        hmap.remove(null);

        hmap.clear();

        hmap.containsKey("");

        hmap.put("12", "Chaitanya");
        hmap.put("2", "Rahul");
        hmap.put("7", "Singh");
        hmap.put("49", "Ajeet");
        hmap.put("3", "Anuj");

        /* Display content using Iterator*/
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        // 迭代hashmap
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }
        for (Map.Entry me : hmap.entrySet()) {
            System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
        }


        // method
        hmap.clone();
        //是否找到指定的key
        hmap.containsKey("");
        //是否找到指定的value
        hmap.containsValue("");
        hmap.get("");
        hmap.isEmpty();
        //返回keys的set
        hmap.keySet();
        // 新增
        hmap.put("","");
        hmap.size();
        //返回所有的值
        hmap.values();
        hmap.remove("");
        hmap.putAll(new HashMap<>());
        // hashTable 无法使用null作为key htabl.put(null,"");

        //当插入两个一样的键时，后插入的一个是否会替代掉前一个

    }

}
