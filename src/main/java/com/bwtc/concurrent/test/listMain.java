package com.bwtc.concurrent.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 16:16 2018/6/14
 **/
public class listMain {

    static int[] arr={1,3,4,5,6,7,8,9,10};

    public static void main(String[] args){

/*
        Arrays.stream(arr).map((x)->x=x+1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::println);
*/
        int num=2;
        Function<Integer,Integer> stringConverter=(from)->from*num;

        System.out.println(stringConverter.apply(3));

    }

}
