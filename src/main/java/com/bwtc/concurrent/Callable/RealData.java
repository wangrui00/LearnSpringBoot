package com.bwtc.concurrent.Callable;

import java.util.concurrent.Callable;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 20:31 2018/6/11
 **/
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para){
        this.para=para;
    }

    @Override
    public String call() throws Exception{
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            sb.append(para);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
