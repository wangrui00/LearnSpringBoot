package com.bwtc.concurrent.worker;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:08 2018/5/30
 **/
public class Worker2 extends Thread{

    //工作者名
    private String name;

    //工作时间
    private long time;

    private CountDownLatch countDownLatch;

    public Worker2(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+"开始工作");
            Thread.sleep(time);
            System.out.println(name+"工作完成，耗费时间="+time);
            countDownLatch.countDown();
            System.out.println("countDownLatch.getCount()="+countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
