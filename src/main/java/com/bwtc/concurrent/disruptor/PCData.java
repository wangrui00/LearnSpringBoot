package com.bwtc.concurrent.disruptor;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:48 2018/6/7
 **/
public class PCData {

    private long value;

    public void set(long value){
        this.value=value;
    }

    public long get(){
        return value;
    }
}
