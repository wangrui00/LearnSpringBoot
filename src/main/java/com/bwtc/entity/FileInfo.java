package com.bwtc.entity;

import java.util.logging.FileHandler;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 18:12 2018/5/26
 **/
public class FileInfo {

    private String path;

    public FileInfo(String path){
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
