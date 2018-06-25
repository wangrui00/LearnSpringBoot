package com.bwtc.concurrent.Callable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 14:19 2018/6/15
 **/
public class FutureAlc {

    public static Integer calc(Integer para){
        try{
            //模拟一个长时间的执行
            Thread.sleep(2000);
        }catch (InterruptedException e){
        }
        return para*para;
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        final CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->calc(50));
        System.out.println(future.get());
    }

}
