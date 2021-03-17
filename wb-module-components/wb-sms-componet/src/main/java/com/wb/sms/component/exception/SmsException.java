package com.wb.sms.component.exception;

/**
 * @ClassName: SmsException
 * @Package: com.wb.sms.component.exception
 * @Description: the sms exception
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class SmsException extends RuntimeException {

    /**
     * constructs a new sms exception with the message.
     *
     * @param message the message
     */
    public SmsException(String message) {
        super(message);
    }

    /**
     * constructs a new sms exception with the message and cause.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SmsException(String message, Throwable cause) {
        super(message, cause);
    }
}
