package com.wb.oss.service.vo;

import java.io.InputStream;

/**
 * @ClassName: FileSingleVo
 * @Package: com.wb.oss.service.vo
 * @Description: the file single vo
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class FileSingleVo {

    //  the file name
    private String fileName;

    //  the file size
    private long size;

    //  the file content
    private InputStream fileContent;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public InputStream getFileContent() {
        return fileContent;
    }

    public void setFileContent(InputStream fileContent) {
        this.fileContent = fileContent;
    }
}
