package com.bwtc.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:12 2018/5/28
 **/
public class DivTask implements Runnable{

    private int a,b;

    public DivTask(int a,int b){
        this.a=a;
        this.b=b;
    }

    @Override
    public void run(){
        double re=a/b;
        System.out.println(re);
    }

    public static void main(String[] args) throws Exception{
        
        ThreadPoolExecutor pools=new ThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        for (int i=0;i<5;i++) {
            Future re=pools.submit(new DivTask(100,i));
            re.get();
        }
    }

}
