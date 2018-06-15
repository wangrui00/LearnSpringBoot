package com.bwtc.concurrent.multi;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 20:59 2018/6/11
 **/
public class Plus implements Runnable{

    public static BlockingQueue<Msg> bq=new LinkedBlockingDeque<Msg>();

    @Override
    public void run(){
        while(true){
            try{
                Msg msg=bq.take();
                msg.j=msg.i+msg.j;
                Multiply.bq.add(msg);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
