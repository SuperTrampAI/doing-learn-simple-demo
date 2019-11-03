package com.supertrampai.lambdasimplelearn.demo;

import java.util.ArrayList;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 9:42 2019/10/15
 * @Modified By:
 */
public class Test {

    public static void main(String args[])
    {
        // lambda expression to implement above
        // functional interface. This interface
        // by default implements abstractFun()
        FuncInterface fobj = (int x)->System.out.println(2*x);
        // This calls above lambda expression and prints 10.
        fobj.abstractFun(5);
// -----------------------------------------------
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        // 语法：param->method(param);
        arrayList.forEach(n->System.out.println(n));
        //
        arrayList.forEach(n->{if(n%2==0){System.out.println(n);}});
// -----------------------------------------------------



    }


}
