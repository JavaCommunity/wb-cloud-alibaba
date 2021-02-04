package com.wb.quartz.component.exception;

/**
 * @ClassName: QuartzServiceException
 * @Package: com.wb.quartz.component.exception
 * @Description: the quartz service exception
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
public class QuartzServiceException extends RuntimeException {

    /**
     * constructs a  new quartzServiceException with the specified message
     *
     * @param msg the message
     */
    public QuartzServiceException(String msg) {
        super(msg);
    }
}
