package com.supertrampai.lambdasimplelearn;

import java.util.concurrent.TimeUnit;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 23:11 2019/11/6
 * @Modified By:
 */
public class TestThreads {

    public static void main(String[] args) {
        Runnable tak=()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String threadName=Thread.currentThread().getName();
            System.out.println("Hello,"+threadName);
        };

        Thread thread=new Thread(tak);

        thread.start();

        System.out.println("Done;");
    }

}
