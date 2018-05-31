package com.bwtc.concurrent.worker;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:24 2018/5/30
 **/
public class Worker3 extends Thread{

    //工作者名
    private String name;

    //第一阶段工作时间
    private long time;

    private CountDownLatch countDownLatch;

    public Worker3(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        try {
            System.out.println(name+"开始工作");
            Thread.sleep(time);
            System.out.println(name+"第一阶段工作完成");
            countDownLatch.countDown();
            Thread.sleep(2000); //这里就姑且假设第二阶段工作都是要2秒完成
            System.out.println(name+"第二阶段工作完成");
            System.out.println(name+"工作完成，耗费时间="+(time+2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
