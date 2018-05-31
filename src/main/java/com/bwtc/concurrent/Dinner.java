package com.bwtc.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:44 2018/5/30
 **/
public class Dinner implements Runnable{

    private String name;

    private ConcurrentLinkedQueue<String> queue;

    private CountDownLatch count;

    public Dinner(String name, ConcurrentLinkedQueue<String> queue, CountDownLatch count) {
        this.name = name;
        this.queue = queue;
        this.count = count;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()){
            //从队列取出一个元素 排队的人少一个
            System.out.println("【" +queue.poll() + "】----已吃完...， 饭桌编号：" + name);
        }
        count.countDown();//计数器-1
        System.out.println("count is "+count.getCount());
    }
}
