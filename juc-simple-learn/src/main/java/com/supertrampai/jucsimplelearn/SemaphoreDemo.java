package com.supertrampai.jucsimplelearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 13:35 2019/11/18
 * @Modified By:
 */
public class SemaphoreDemo {

    //semaphore 可以控制同时访问的线程个数

    // 比如，控制五个线程，被N个人请求，只有当使用完了，释放。才能被其他人使用。
    public static void main(String[] args) {
        int N=8;
        ExecutorService service = Executors.newCachedThreadPool();//使用并发库，创建缓存的线程池
        Semaphore semaphore=new Semaphore(5);
        System.out.println("可用并发次数："+semaphore.availablePermits());
        for (int i=0;i<N;i++){
            //new Worker(i,semaphore).start();
            service.execute(new Worker(i,semaphore));
        }
        service.shutdown(); //关闭线程池
    }
    static class Worker extends Thread{



        private int num;
        private Semaphore semaphore;
        public Worker(Integer num,Semaphore semaphore){
            this.num=num;
            this.semaphore=semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获取许可
                System.out.println(Thread.currentThread().getName()+"获取线程完成"+"剩余："+semaphore.availablePermits());
                Thread.sleep(2000);
                semaphore.release();//释放许可
                System.out.println(Thread.currentThread().getName()+"释放资源完成"+"剩余："+semaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}


