package com.bwtc.concurrent.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 15:56 2018/6/11
 **/
public class MyRunnable1 implements Runnable{

    CountDownLatch latch = null;
    int i;

    public MyRunnable1(CountDownLatch latch, int i) {
        this.latch = latch;
        this.i = i;
    }

    @Override
    public void run() {
        System.err.println("线程" + i +"完成了操作...");
        try {
            Thread.currentThread();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
