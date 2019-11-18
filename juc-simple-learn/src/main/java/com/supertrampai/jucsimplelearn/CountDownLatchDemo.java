package com.supertrampai.jucsimplelearn;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.concurrent.CountDownLatch;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:13 2019/11/11
 * @Modified By:
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(5);
        Worker w1=new Worker(1000,latch,"ww1");
        Worker w2=new Worker(2000,latch,"ww2");
        Worker w3=new Worker(3000,latch,"ww3");
        Worker w4=new Worker(4000,latch,"ww4");
        Worker w5=new Worker(5000,latch,"ww5");

        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();

        System.out.println("等待若干个子线程执行完毕");
        latch.await();

        System.out.println(Thread.currentThread().getName());
    }



}

class Worker extends Thread{

    private int delay;

    private CountDownLatch latch;

    public  Worker(int delay,CountDownLatch latch , String name){
        super(name);
        this.delay=delay;
        this.latch=latch;
    }

    @Override
    public void run() {
        try {
            System.out.println();
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+"finished");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
