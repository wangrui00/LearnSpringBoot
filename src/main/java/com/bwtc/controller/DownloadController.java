package com.bwtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author wangrui
 * @Description: 下载文件
 * @Date:Created in 18:00 2018/6/25
 **/
@Controller
@RequestMapping("download")
public class DownloadController {

    @ResponseBody
    @RequestMapping("/file")
    public void download(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String fileName="test.docx";
        InputStream inStream = new FileInputStream("/test.docx");// 文件的存放路径
        //设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
