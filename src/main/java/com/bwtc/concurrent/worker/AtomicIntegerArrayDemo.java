package com.bwtc.concurrent.worker;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 8:56 2018/6/1
 **/
public class AtomicIntegerArrayDemo {

    static AtomicIntegerArray arr=new AtomicIntegerArray(10);

    public static class AddThread implements Runnable{

        @Override
        public void run(){
            for(int k=0;k<10000;k++){
                arr.getAndIncrement(k%arr.length());
            }
        }
    }

    public static void main(String[] args)throws  InterruptedException{
        Thread[] ts=new Thread[10];
        for(int k=0;k<10;k++){
            ts[k]=new Thread(new AddThread());
        }
        for(int k=0;k<10;k++){ts[k].start();}
        for(int k=0;k<10;k++){ts[k].join();}
        System.out.println(arr);
    }
}
