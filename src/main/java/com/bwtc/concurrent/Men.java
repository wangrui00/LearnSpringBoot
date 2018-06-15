package com.bwtc.concurrent;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 20:38 2018/6/6
 **/
public class Men implements Human{

    @Override
    public void eat() {
        System.out.println("eat Men");
    }

    @Override
    public void sing() {
        System.out.println("he Men");
    }
}
