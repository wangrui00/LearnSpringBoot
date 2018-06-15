package com.bwtc.concurrent.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 15:43 2018/6/11
 **/
public class MyRunnable implements Runnable{

    private final CountDownLatch countDown;

    private final CountDownLatch await;

    public MyRunnable(CountDownLatch countDownLatch,CountDownLatch await){
        this.countDown=countDownLatch;
        this.await=await;
    }

    public void run(){
        try{
            countDown.await();//等待主线程执行完毕，获得开始执行信号...
            System.out.println("处于等待的线程开始自己预期工作....");
            await.countDown();//完成预期工作，发出完成信号....
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
