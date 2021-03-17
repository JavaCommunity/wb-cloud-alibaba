package com.wb.sms.component.exception;

/**
 * @ClassName: SmsIllegalArgumentException
 * @Package: com.wb.sms.component.exception
 * @Description: the sms illegal argument exception
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
public class SmsIllegalArgumentException extends SmsException {

    /**
     * constructs a new sms illegal argument exception with the message.
     *
     * @param message the message
     */
    public SmsIllegalArgumentException(String message) {
        super(message);
    }

    /**
     * constructs a new sms illegal argument exception with the message and cause.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SmsIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
