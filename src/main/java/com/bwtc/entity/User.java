package com.bwtc.entity;

import java.util.Date;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:16 2018/5/26
 **/
public class User {

    private Integer id;

    private String username;

    private String password;

    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
