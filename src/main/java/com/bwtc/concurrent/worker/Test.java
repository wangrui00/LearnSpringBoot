package com.bwtc.concurrent.worker;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:56 2018/5/30
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        Worker3 worker0 = new Worker3("worker0", (long) (Math.random()*2000+3000),countDownLatch);
        Worker3 worker1 = new Worker3("worker1", (long) (Math.random()*2000+3000),countDownLatch);
        Worker3 worker2 = new Worker3("worker2", (long) (Math.random()*2000+3000),countDownLatch);
        worker0.start();
        worker1.start();
        countDownLatch.await();
        System.out.println("准备工作就绪");
        worker2.start();
    }
}
