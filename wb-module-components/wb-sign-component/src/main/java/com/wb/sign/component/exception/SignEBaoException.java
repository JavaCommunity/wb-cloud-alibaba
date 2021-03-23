package com.wb.sign.component.exception;

/**
 * @ClassName: SignEBaoException
 * @Package: com.wb.sign.component.exception
 * @Description: the sign e bao exception
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class SignEBaoException extends SignException {

    /**
     * constructs a new sign e bao exception with the specified message.
     *
     * @param message the message
     */
    public SignEBaoException(String message) {
        super(message);
    }

    /**
     * constructs a new sign e bao exception with the specified message and cause.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SignEBaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
