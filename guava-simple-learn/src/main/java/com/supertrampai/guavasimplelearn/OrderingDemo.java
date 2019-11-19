package com.supertrampai.guavasimplelearn;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.Comparator;

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
                return 0;
            }
        });

        Ordering<String> byLengthOrdering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };




    }

}
