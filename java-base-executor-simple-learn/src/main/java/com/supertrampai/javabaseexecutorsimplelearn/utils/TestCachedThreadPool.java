package com.supertrampai.javabaseexecutorsimplelearn.utils;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 15:51 2019/9/22
 * @Modified By:
 */
public class TestCachedThreadPool {

    public static void main(String[] args){

        /**
         * 核心线程数量为0。
         * 如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，
         * 当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
         * 此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
         */
        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * 每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
         * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
         * 返回一个包含指定数目线程的线程池，如果任务数量多于线程数目，那么没有没有执行的任务必须等待，直到有任务完成为止。
         */
//      ExecutorService executorService = Executors.newFixedThreadPool(5);


        /**
         *只有一个线程在工作，相当于单线程串行执行所有任务。
         * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
         */
//      ExecutorService executorService = Executors.newSingleThreadExecutor();


        /**
         * 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
         */
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);

        ses.scheduleWithFixedDelay(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date());
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        /**
         * 此线程池支持定时以及周期性执行任务的需求。
         */
//      ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 5; i++){
            executorService.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
    }

}
class TestRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
    }
}


