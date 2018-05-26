package com.bwtc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 12:24 2018/5/26
 **/
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args){
        ConfigurableApplicationContext context=SpringApplication.run(SpringbootApplication.class,args);
       /* Map<String,Encodingconvertor> map=context.getBeansOfType(Encodingconvertor.class);
        System.out.println(map);*/
        //context.getBean(DataSourceProperties.class).show();
    }
}
