package com.wb.common.exception;

/**
 * @ClassName: ServiceException
 * @Package: com.wb.common.exception
 * @Description: the service exception
 * @Author：[bo.wang]
 * @Date: 2021/1/19
 * @Version: 1.0
 */
public class ServiceException extends RuntimeException {

    //  the exception cls
    private Class<?> cls;

    /**
     * Constructs a new ServiceException with the specified cls
     *
     * @param cls the cls
     */
    public ServiceException(Class<?> cls) {
        super();
        this.cls = cls;
    }

    /**
     * Constructs a new ServiceException with the specified message and cls
     *
     * @param message the message
     * @param cls     the cls
     */
    public ServiceException(String message, Class<?> cls) {
        super(message);
        this.cls = cls;
    }
}
