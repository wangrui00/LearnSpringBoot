package com.bwtc.concurrent.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:49 2018/6/7
 **/
public class Consumer implements WorkHandler<PCData> {

    @Override
    public void onEvent(PCData event) throws Exception{
        System.out.println(Thread.currentThread().getId()+":Event: --"+event.get()*event.get()+"--");
    }
}
