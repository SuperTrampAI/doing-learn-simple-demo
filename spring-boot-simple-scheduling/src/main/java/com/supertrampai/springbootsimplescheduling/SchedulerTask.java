package com.supertrampai.springbootsimplescheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/11 16:56
 */
@Component
public class SchedulerTask {

    private int count=0;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }


    /**
     * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
     * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执行一次
     */
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay=6000)
    public void fixedDelayJob(){
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+" >>fixedDelay执行....");
    }

    //fixedRate就是每多次分钟一次，不论你业务执行花费了多少时间。我都是1分钟执行1次，\
    //而fixedDelay是当任务执行完毕后1分钟在执行。

    //执行多个任务，如果一个任务卡死，会导致其他任务也无法执行




}
