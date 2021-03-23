package com.wb.sign.component.exception;

/**
 * @ClassName: SignException
 * @Package: com.wb.sign.component.exception
 * @Description: the sign exception
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class SignException extends RuntimeException {

    /**
     * constructs a new sign exception with the specified message.
     *
     * @param message the message
     */
    public SignException(String message) {
        super(message);
    }

    /**
     * constructs a new sign exception with the specified message and cause.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SignException(String message, Throwable cause) {
        super(message, cause);
    }
}
