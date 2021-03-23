package com.wb.sign.component.exception;

/**
 * @ClassName: SignIllegalArgumentException
 * @Package: com.wb.sign.component.exception
 * @Description: the sign illegal argument exception
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class SignIllegalArgumentException extends RuntimeException {

    /**
     * constructs a new sign illegal argument exception with
     * the specified message.
     *
     * @param message the message
     */
    public SignIllegalArgumentException(String message) {
        super(message);
    }

    /**
     * constructs a new sign illegal argument exception with
     * the specified message and cause.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SignIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
