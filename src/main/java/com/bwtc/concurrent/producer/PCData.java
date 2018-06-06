package com.bwtc.concurrent.producer;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 16:45 2018/6/2
 **/
public final class PCData {

    private final int intData;

    public PCData(int d){
        intData=d;
    }
    public PCData(String id){
        intData=Integer.valueOf(id);
    }

    public int getData(){
        return intData;
    }

    @Override
    public String toString(){
        return "data:"+intData;
    }
}
