package com.wb.admin.service.exception;

/**
 * @ClassName: AdminServiceException
 * @Package: com.wb.admin.service.exception
 * @Description: 自定义admin service异常
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
public class AdminServiceException extends RuntimeException {

    public AdminServiceException() {
        super();
    }

    public AdminServiceException(String message) {
        super(message);
    }

    public AdminServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
