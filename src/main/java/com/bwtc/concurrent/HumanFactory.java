package com.bwtc.concurrent;

import com.bwtc.concurrent.Callable.WoMan;

import java.util.HashMap;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 20:58 2018/6/6
 **/
public class HumanFactory {

    //定义一个Map,初始化过的Human对象都放在这里
    private static HashMap<String,Human> humans=new HashMap<String,Human>();

    public static Human createHuman(Class c){
        Human human=null;//定义一个类型的人类
        try{
            //如果Map中有，则直接从取出，不用初始化了
            if(humans.containsKey(c.getSimpleName())){
                human=humans.get(c.getSimpleName());
            }else{
                human=(Human)Class.forName(c.getName()).newInstance();
                //放到Map中
                humans.put(c.getSimpleName(),human);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return human;
    }

    public static void main(String[] args){

    }

}
