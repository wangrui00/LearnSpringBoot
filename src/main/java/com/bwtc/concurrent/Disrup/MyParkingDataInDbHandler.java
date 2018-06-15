package com.bwtc.concurrent.Disrup;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @Author wangrui
 * @Description: Handler第一个消费者，负责保存进场汽车的信息
 * @Date:Created in 16:33 2018/6/9
 **/
public class MyParkingDataInDbHandler implements EventHandler<MyInParkingDataEvent>,WorkHandler<MyInParkingDataEvent> {

    @Override
    public void onEvent(MyInParkingDataEvent myInParkingDataEvent) throws Exception{
        long threadId=Thread.currentThread().getId();  //获取当前线程id
        String carLicense=myInParkingDataEvent.getCarLicense();//获取车牌号
        System.out.println(String.format("Thread Id %s 保存 %s到数据库中 ....",threadId,carLicense));
    }

    @Override
    public void onEvent(MyInParkingDataEvent myInParkingDataEvent,long sequence,boolean endOfBatch) throws Exception{
        this.onEvent(myInParkingDataEvent);
    }
}
