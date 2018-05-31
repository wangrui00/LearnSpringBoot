package com.bwtc.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:42 2018/5/30
 **/
public class Test01ConcurrentLinkedQueue {

    public static void main(String[] args) throws InterruptedException{

        int peopleNum=10000;//吃饭人数

        int tableNum=10;//饭桌数量

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        CountDownLatch count = new CountDownLatch(tableNum);//计数器

        //将吃饭人数放入队列（吃饭的人进行排队）
        for(int i=1;i<=peopleNum;i++){
            queue.offer("消费者_" + i);
        }
        //执行10个线程从队列取出元素（10个桌子开始供饭）
        System.out.println("====================开饭了======================");
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(tableNum);
        for(int i=0;i<tableNum;i++) {
            executorService.submit(new Dinner("00" + (i+1), queue, count));
        }

        //计数器等待，知道队列为空（所有人吃完）
        count.await();
        long time = System.currentTimeMillis() - start;
        System.out.println("-----------------------------------所有人已经吃完-----------------------------------");
        System.out.println("共耗时：" + time);
        //停止线程池
        executorService.shutdown();
    }
}
