package com.bwtc.concurrent.multi;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 21:01 2018/6/11
 **/
public class Multiply implements  Runnable{

    public static BlockingQueue<Msg> bq=new LinkedBlockingDeque<Msg>();

    @Override
    public void run(){
        while(true){
            try{
                Msg msg=bq.take();
                msg.i=msg.i*msg.j;
                Div.bq.add(msg);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
