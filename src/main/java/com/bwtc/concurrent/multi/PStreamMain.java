package com.bwtc.concurrent.multi;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 21:06 2018/6/11
 **/
public class PStreamMain {

    public static void main(String[] args){
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for(int i=1;i<=1000;i++){
            for(int j=1;j<=1000;j++){
                Msg msg=new Msg();
                msg.i=i;
                msg.j=j;
                msg.orgStr="((" + i + "+" + j + ")*"+i+")/2";
                Plus.bq.add(msg);
            }
        }
    }
}
