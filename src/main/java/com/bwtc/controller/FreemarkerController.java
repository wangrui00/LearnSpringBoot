package com.bwtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:01 2018/5/26
 **/
@Controller
@RequestMapping("freemarker")
public class FreemarkerController {

    @RequestMapping("hello")
    public String hello(Map<String,Object> map){
        map.put("msg","Hello Freemarker");
        return "hello";
    }
}
