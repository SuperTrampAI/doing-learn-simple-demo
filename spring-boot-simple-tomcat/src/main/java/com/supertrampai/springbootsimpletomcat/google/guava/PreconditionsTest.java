package com.supertrampai.springbootsimpletomcat.google.guava;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:13 2019/9/1
 * @Modified By:
 */
public class PreconditionsTest {

    public static void main(String[] args) {
        PreconditionsTest proTest=new PreconditionsTest();
        Integer a=new Integer(1);
    }


    public static Optional<Integer> testMenthod(Optional<Integer> value1){
        Preconditions.checkArgument(true,value1);
        return value1;
    }

}
