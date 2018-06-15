package com.bwtc.concurrent.stream;

import java.util.stream.IntStream;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 11:37 2018/6/15
 **/
public class PrimeUtil {

    public static boolean isPrime(int number){
        int tmp=number;
        if(tmp<2){
            return false;
        }
        for(int i=2;Math.sqrt(tmp) >=i;i++){
            if(tmp%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        System.out.println(IntStream.range(1,1000000).filter(PrimeUtil::isPrime).count());
        long zhongTime=System.currentTimeMillis();
        System.out.println(zhongTime-startTime);
        System.out.println(IntStream.range(1,1000000).parallel().filter(PrimeUtil::isPrime).count());
        System.out.println(System.currentTimeMillis()-zhongTime);
    }
}
