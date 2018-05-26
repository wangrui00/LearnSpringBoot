package com.bwtc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 12:25 2018/5/26
 **/
@RestController
public class TestController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping("helloworld")
    public String helloworld(){
        logger.info("helloworld");
        return "helloworld";
    }

    @GetMapping("getUser")
    public String getUser(){
        return "wangrui";
    }
}
