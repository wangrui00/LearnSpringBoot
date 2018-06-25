package com.bwtc.concurrent.test;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 10:27 2018/6/21
 **/
public class FileVO {

    private long fileId;

    // 文件所在的目录
    private long catalogId;

    // 文件类型 1 文件; 2 目录
    private int fileType;

    public FileVO() {

    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(long catalogId) {
        this.catalogId = catalogId;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }
}
