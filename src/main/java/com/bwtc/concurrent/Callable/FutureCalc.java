package com.bwtc.concurrent.Callable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:06 2018/6/15
 **/
public class FutureCalc {

    public static Integer calc(Integer para){
        return para/2;
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(()->calc(50));
        CompletableFuture<Integer> intFuture2= CompletableFuture.supplyAsync(()->calc(25));

        CompletableFuture<Void> fu=intFuture.thenCombine(intFuture2,(i,j)->(i+j))
                .thenApply((str) -> "\""+str+"\"")
                .thenAccept(System.out::println);
        fu.get();
    }
}
