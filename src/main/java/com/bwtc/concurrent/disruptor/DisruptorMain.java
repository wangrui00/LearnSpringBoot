package com.bwtc.concurrent.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:02 2018/6/7
 **/
public class DisruptorMain {

    public static void main(String[] args) throws Exception{
        Executor executor= Executors.newCachedThreadPool();
        PCDataFactory factory=new PCDataFactory();
        int bufferSize=1024;
        //消费者
        Disruptor<PCData> disruptor=new Disruptor<PCData>(factory,bufferSize,executor, ProducerType.MULTI,new BlockingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(new Consumer(),new Consumer(),new Consumer(),new Consumer());
        disruptor.start();

        //启动并初始化disruptor系统
        RingBuffer<PCData> ringBuffer=disruptor.getRingBuffer();
        Producer producer=new Producer(ringBuffer);
        ByteBuffer bb=ByteBuffer.allocate(8);
        for(long l=0;true;l++){
            bb.putLong(0,1);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.println("add data "+l);
        }
    }
}
