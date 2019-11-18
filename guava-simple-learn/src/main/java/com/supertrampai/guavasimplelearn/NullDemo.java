package com.supertrampai.guavasimplelearn;

import com.google.common.base.Optional;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 17:22 2019/11/18
 * @Modified By:
 */
public class NullDemo {

    public static void main(String[] args) {

        Optional<Integer> integerOptional=Optional.of(3);
        Optional <Integer> integerOptional1=Optional.fromNullable(null);
        System.out.println(integerOptional1.orNull());
        System.out.println(integerOptional.isPresent()+":"+integerOptional.get());//不为null，返回true
        //System.out.println(integerOptional.isPresent());//如果为null，则抛出nullpointerexception
    }

}
