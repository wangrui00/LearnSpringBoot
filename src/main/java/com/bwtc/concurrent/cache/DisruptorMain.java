package com.bwtc.concurrent.cache;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.awt.*;
import java.util.concurrent.ThreadFactory;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 16:12 2018/6/9
 **/
public class DisruptorMain {

    public static void main(String[] args) throws Exception{

        //队列中的元素
        class Element{

            private int value;

            public int get(){
                return value;
            }

            public void set(int value){
                this.value=value;
            }
        }

        //生产者的线程工厂
        ThreadFactory threadFactory=new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "simpleThread");
            }
        };

        //RingBuffer生产工厂，初始化RingBuffer的时候使用
        EventFactory<Element> factory=new EventFactory<Element>() {
            @Override
            public Element newInstance() {
                return new Element();
            }
        };

        //处理Event的handler
        EventHandler<Element> handler=new EventHandler<Element>() {
            @Override
            public void onEvent(Element element, long l, boolean b) throws Exception {
                System.out.println("Element :"+element.get());
            }
        };

        //阻塞策略
        BlockingWaitStrategy strategy=new BlockingWaitStrategy();

        //指定RingBuffer的大小
        int bufferSize=16;

        //创建disruptor，采用单生产者模式

    }
}
