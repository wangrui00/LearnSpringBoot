package com.bwtc.concurrent.worker;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 21:11 2018/5/30
 **/
public class AtomicIntegerDemo {

    static AtomicInteger i=new AtomicInteger();

    public static class AddThread implements Runnable{

        public void run(){
            for(int k=0;k<10000;k++){
                i.incrementAndGet();
            }
        }

        public static void main(String[] args)throws InterruptedException{
           int a=2;
           int b=a+1;
           System.out.println("a "+a);
            System.out.println("b "+b);
            /* Thread[] ts=new Thread[10];
            for(int k=0;k<10;k++){
                ts[k]=new Thread(new AddThread());
            }
            for(int k=0;k<10;k++){ts[k].start();}
            for(int k=0;k<10;k++){ts[k].join();}
            System.out.println(i);*/
        }
    }
}
