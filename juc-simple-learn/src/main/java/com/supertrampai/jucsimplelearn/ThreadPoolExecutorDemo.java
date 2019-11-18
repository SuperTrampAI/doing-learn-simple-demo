package com.supertrampai.jucsimplelearn;

import java.util.concurrent.*;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 15:06 2019/11/18
 * @Modified By:
 */
public class ThreadPoolExecutorDemo {


    //线程池可以实现线程的复用，在线程使用完时，不销毁。而是可以继续执行其他的任务。
    //构造函数参数解释
    //1 corePoolSize :即在没有任务到来之前就创建corePoolSize个线程或者一个线程
    // maximumPoolSize 线程池中最多能创建多少个线程。
    public static void main(String[] args) {
        // java doc中，并不提倡直接使用ThreadPoolExecutor，而是使用Executor的几个静态方法创建线程池，
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
        //       new ArrayBlockingQueue<Runnable>(5));

        ExecutorService pool = Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE

        Worker w1=new Worker();
        Worker w2=new Worker();
        Worker w3=new Worker();
        Worker w4=new Worker();

        pool.execute(w1);
        pool.execute(w2);
        pool.execute(w3);
        pool.execute(w4);

        //关闭线程有两个方法
        //shutdown() 执行后停止接受新任务，会把队列的任务执行完毕。
        //shutdownNow() 也是停止接受新任务，但会中断所有的任务，将线程池状态变为 stop。
        pool.shutdown();//关闭线程池



        Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
        Executors.newFixedThreadPool(5);    //创建固定容量大小的缓冲池

    }

    static  class Worker extends  Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"正在执行");
        }
    }


}
