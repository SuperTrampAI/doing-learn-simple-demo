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

        //参数不能是nulll
        Optional<Integer> integerOptional=Optional.of(1);

        //参数可以是null和非null
        Optional <Integer> integerOptional1=Optional.fromNullable(null);

        //意义在哪？
        Optional<Integer> integerOptional2=Optional.absent();

        // or: 如果初始值为null，则返回or中的参数，不为空，返回原来的值
        System.out.println(integerOptional2.or(3));

        //方法：
        // 如果应用存在，返回true
        integerOptional.isPresent();

        // 返回包含的应用，如果应用缺失，抛出异常
        integerOptional.get();

        // 如果不存在，返回指定值
        integerOptional.or(23);

        //如果不存在，返回null
        integerOptional.orNull();

        integerOptional.asSet();

        //System.out.println(integerOptional1.orNull());
        //System.out.println(integerOptional.isPresent()+":"+integerOptional.get());//不为null，返回true
        //System.out.println(integerOptional.isPresent());//如果为null，则抛出nullpointerexception

    }

}
