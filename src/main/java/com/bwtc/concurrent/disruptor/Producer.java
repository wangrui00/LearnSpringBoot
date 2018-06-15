package com.bwtc.concurrent.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:56 2018/6/7
 **/
public class Producer {

    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer){
        this.ringBuffer=ringBuffer;
    }

    public void pushData(ByteBuffer bb){
        long sequence=ringBuffer.next();
        try{
            PCData event=ringBuffer.get(sequence);
            event.set(bb.getLong(0));
        }finally {
            ringBuffer.publish(sequence);
        }
    }
}
