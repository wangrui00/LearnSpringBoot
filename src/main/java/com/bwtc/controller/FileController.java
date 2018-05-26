package com.bwtc.controller;

import com.bwtc.entity.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 18:13 2018/5/26
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    private String path="d:\\";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws Exception {
        logger.debug("upload function of fileName is {}",file.getName());
        logger.debug("upload function of OriginalFileName is {}",file.getOriginalFilename());
        logger.debug("upload function of fileSize is {}",file.getSize());
        File localFile = new File(path, file.getOriginalFilename());
        file.transferTo(localFile);
        logger.debug("upload function of absolutePath is {}",localFile.getAbsolutePath());
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try (InputStream inputStream = new FileInputStream(new File(path, id + ".jpg"));
             OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + id + ".jpg");
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
