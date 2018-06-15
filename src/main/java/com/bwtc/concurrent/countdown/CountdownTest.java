package com.bwtc.concurrent.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 15:32 2018/6/11
 **/
public class CountdownTest {

    public static void main(String[] args) throws InterruptedException{

        CountDownLatch countDown=new CountDownLatch(1);
        CountDownLatch await=new CountDownLatch(5);

        //依次创建并启动处于等待状态的5个MyRunnable线程
        for(int i=0;i<5;i++){
            new Thread(new MyRunnable(countDown,await)).start();
        }

        System.out.println("用于触发处于等待状态的线程开始工作....");
        System.out.println("用于触发处于等待状态的线程工作完成，等待状态线程开始工作.....");
        System.out.println("countDown size is "+countDown.getCount());
        countDown.countDown();
        await.await();
        System.out.println("await size is "+await.getCount());
        System.out.println("Bingo!");
    }
}
