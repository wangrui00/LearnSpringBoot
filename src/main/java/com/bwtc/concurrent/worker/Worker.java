package com.bwtc.concurrent.worker;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 9:55 2018/5/30
 **/
public class Worker extends Thread{

    private String name;//工作者名

    private long time;//工作时间

    public Worker(String name,long time){
        this.name=name;
        this.time=time;
    }

    @Override
    public void run(){
        try {
            System.out.println(name+"开始工作");
            Thread.sleep(time);
            System.out.println(name+"工作完成，耗费时间="+time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
