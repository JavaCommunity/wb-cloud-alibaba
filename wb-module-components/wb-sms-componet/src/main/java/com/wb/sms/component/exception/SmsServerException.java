package com.wb.sms.component.exception;

/**
 * @ClassName: SmsServerException
 * @Package: com.wb.sms.component.exception
 * @Description: the sms server exception
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
public class SmsServerException extends SmsException {

    /**
     * constructs a new sms server exception with the message.
     *
     * @param message the message
     */
    public SmsServerException(String message) {
        super(message);
    }

    /**
     * constructs a new sms server exception with the message and cause.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SmsServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
