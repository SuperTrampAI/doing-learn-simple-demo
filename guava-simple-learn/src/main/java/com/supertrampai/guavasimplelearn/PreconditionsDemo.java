package com.supertrampai.guavasimplelearn;

import com.google.common.base.Preconditions;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 10:40 2019/11/19
 * @Modified By:
 */
public class PreconditionsDemo {

    public static void main(String[] args) {

        boolean b=true;
        boolean b1=false;

        Integer integer=12;
        Integer integer1=null;

        String[] strings=new String[5];
        // 检查boolean是否为true，用来检查参数
        Preconditions.checkArgument(b);

        //如果为null，直接抛出异常
        Preconditions.checkNotNull(integer);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");


        // 如果为false，则抛出异常
        Preconditions.checkState(b);

        // 如果index>=0 and < size  则返回index，否则抛出异常
        System.out.println(Preconditions.checkElementIndex(1,strings.length));

        // startIndex endIndex 在size中是否有效
        Preconditions.checkPositionIndexes(1,2,strings.length);



    }

}
