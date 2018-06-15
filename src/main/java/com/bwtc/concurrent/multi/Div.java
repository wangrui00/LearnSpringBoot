package com.bwtc.concurrent.multi;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 21:03 2018/6/11
 **/
public class Div implements Runnable{

    public static BlockingQueue<Msg> bq =new LinkedBlockingDeque<Msg>();

    @Override
    public void run(){
        while(true){
            try{
                Msg msg=bq.take();
                msg.i=msg.i/2;
                System.out.println(msg.orgStr +"=" + msg.i);
            }catch (InterruptedException e){

            }
        }
    }
}
