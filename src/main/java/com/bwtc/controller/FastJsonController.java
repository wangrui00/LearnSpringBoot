package com.bwtc.controller;

import com.bwtc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:17 2018/5/26
 **/
@Controller
@RequestMapping("fastJson")
public class FastJsonController {

    @RequestMapping("/test")
    @ResponseBody
    public User test(){
        User user=new User();
        user.setId(1);
        user.setUsername("jack");
        user.setPassword("jack123");
        user.setBirthday(new Date());
        //模拟异常
        int i=1/0;
        return user;
    }
}
