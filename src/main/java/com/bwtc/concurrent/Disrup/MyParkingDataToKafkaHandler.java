package com.bwtc.concurrent.Disrup;

import com.lmax.disruptor.EventHandler;

/**
 * @Author wangrui
 * @Description:第二个消费者，负责发送通知告知工作人员(kafka是一种高吞吐量的分布式订阅消息系统)
 * @Date:Created in 16:40 2018/6/9
 **/
public class MyParkingDataToKafkaHandler implements EventHandler<MyInParkingDataEvent>{

    @Override
    public void onEvent(MyInParkingDataEvent myInParkingDataEvent,long sequence,boolean endOfBatch) throws Exception{
        long threadId=Thread.currentThread().getId();  //获取当前线程id
        String carLicense=myInParkingDataEvent.getCarLicense();//获取车牌号
        System.out.println(String.format("Thread Id %s 发送%s 进入停车场信息给 kafka系统...",threadId,carLicense));
    }
}
