package com.supertrampai.jucsimplelearn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 15:59 2019/11/15
 * @Modified By:
 */
public class CyclicBarrierDemo {


    //CyclicBarrier 应用场景
    // 假如有若干个线程都要进行写数据操作，并且只要在所有线程都完成写数据以后，这些线程才能进行后面的操作。

    public static void main(String[] args) {
        int N=4;
        CyclicBarrier cyclicBarrier=new CyclicBarrier(N);
        for (int i=0;i<N;i++){
            new Worker(cyclicBarrier).start();
        }
    }

    static class Worker extends  Thread{

        private CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier=cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"正在写入数据");
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"写入数据完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
/*如果把这个类写在该位置，则将会提示重复*/
/*class Worker extends  Thread{

}*/


