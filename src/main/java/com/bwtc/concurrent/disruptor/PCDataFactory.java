package com.bwtc.concurrent.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:55 2018/6/7
 **/
public class PCDataFactory implements EventFactory<PCData>{

    public PCData newInstance(){
        return new PCData();
    }
}
