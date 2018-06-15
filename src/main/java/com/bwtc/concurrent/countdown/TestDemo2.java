package com.bwtc.concurrent.countdown;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 15:55 2018/6/11
 **/
public class TestDemo2 {

    public static void main(String[] args)throws InterruptedException{
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            threadPool.execute(new MyRunnable1(latch, i));
        }

        latch.await();
        System.err.println("等待线程被唤醒！");
        threadPool.shutdown();
    }
}
