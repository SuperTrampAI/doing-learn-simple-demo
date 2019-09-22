package com.supertrampai.javabaseexecutorsimplelearn.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:11 2019/9/22
 * @Modified By:
 */
public class ThreadPoolTest {

    public static void main(String[] args){
        //创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        //创建线程池，池中保存的线程数为3，允许的最大线程数为5
        /**
         * JDK中的线程池由ThreadPoolExecutor类实现
         * corePoolSize：核心线程数。
         * maximumPoolSize：最大线程数。
         * keepAliveTime：线程存活时间。当线程数大于core数，那么超过该时间的线程将会被终结。
         * unit：keepAliveTime的单位。java.util.concurrent.TimeUnit类存在静态静态属性： NANOSECONDS、MICROSECONDS、MILLISECONDS、SECONDS
         * Runnable的阻塞队列。若线程池已经被占满，则该队列用于存放无法再放入线程池中的Runnable。
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,50, TimeUnit.MILLISECONDS,bqueue);
        //创建七个任务
        Runnable t1 = new MyThread();
        Runnable t2 = new MyThread();
        Runnable t3 = new MyThread();
        Runnable t4 = new MyThread();
        Runnable t5 = new MyThread();
        Runnable t6 = new MyThread();
        Runnable t7 = new MyThread();
        //每个任务会在一个线程上执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        //关闭线程池
        pool.shutdown();
    }


}


class MyThread implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}