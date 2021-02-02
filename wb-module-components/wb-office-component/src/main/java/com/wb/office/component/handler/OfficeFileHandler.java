package com.wb.office.component.handler;

/**
 * @ClassName: OfficeFileHandler
 * @Package: com.wb.office.component.handler
 * @Description: the office file handler
 * @Author：[bo.wang]
 * @Date: 2021/2/1
 * @Version: 1.0
 */
public interface OfficeFileHandler {

    /**
     * get file path
     *
     * @param fileId the file id
     * @return the file path
     */
    String getFilePath(String fileId);
}
