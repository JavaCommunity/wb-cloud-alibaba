package com.wb.oss.component.exception;

import com.wb.common.exception.ServiceException;

/**
 * @ClassName: OssServiceException
 * @Package: com.wb.oss.component.exception
 * @Description: the oss service exception
 * @Author：[bo.wang]
 * @Date: 2021/2/1
 * @Version: 1.0
 */
public class OssServiceException extends ServiceException {

    /**
     * constructs a new ossServiceException with the specified class
     *
     * @param cls the class
     */
    public OssServiceException(Class<?> cls) {
        super(cls);
    }

    /**
     * constructs a new ossServiceException with the specified message and class
     *
     * @param message the message
     * @param cls     the class
     */
    public OssServiceException(String message, Class<?> cls) {
        super(message, cls);
    }
}
