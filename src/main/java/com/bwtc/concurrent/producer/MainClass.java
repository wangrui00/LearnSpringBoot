package com.bwtc.concurrent.producer;

import java.awt.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 16:56 2018/6/2
 **/
public class MainClass {

    public static void main(String[] args) throws InterruptedException{
        //建立缓冲区
        BlockingQueue<PCData> queue=new LinkedBlockingDeque<PCData>(10);
        Producer producer1=new Producer(queue);//建立生产者
        Producer producer2=new Producer(queue);
        Producer producer3=new Producer(queue);

        Consumer consumer1=new Consumer(queue);//建立消费者
        Consumer consumer2=new Consumer(queue);
        Consumer consumer3=new Consumer(queue);

        ExecutorService service= Executors.newCachedThreadPool();//建立线程池
        service.execute(producer1);//运行生产者
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        Thread.sleep(10*1000);
        producer1.stop();//停止生产者
        producer2.stop();
        producer3.stop();
        Thread.sleep(3000);
        service.shutdown();
    }
}
