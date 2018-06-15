package com.bwtc.concurrent.Callable;

import com.bwtc.concurrent.Human;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 20:37 2018/6/6
 **/
public class WoMan implements Human{

    @Override
    public void eat() {
        System.out.println("eat !");
    }

    @Override
    public void sing() {
        System.out.println("sing ");
    }
}
