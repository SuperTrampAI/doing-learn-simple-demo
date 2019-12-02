package com.supertrampai.guavasimplelearn;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 15:26 2019/11/22
 * @Modified By:
 */
public class ListenableFutureDemo {


    public static void main(String[] args) {
        //通过MoreExecutors类的静态方法listeningDecorator方法初始化一个ListeningExecutorService的方法
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        //然后使用此实例的submit方法即可初始化listenableFuture对象
        // 上文中定义的ListenableFuture要做的工作，在Callable接口的实现类中定义，这里只是休眠了1秒钟然后返回一个数字7.
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(1);
                return 7;
            }
        });

        //有了ListenableFuture实例，有两种方法可以执行此Future并执行Future完成之后的回调函数。
        //方法一：通过ListenableFuture的addListener方法
        /*listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("get listenable future's result " + listenableFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, executorService);*/

        //方法二：通过Futures的静态方法addCallback给ListenableFuture添加回调函数
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>()  {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        },Executors.newCachedThreadPool());

    }
}
