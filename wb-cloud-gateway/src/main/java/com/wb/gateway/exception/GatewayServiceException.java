package com.wb.gateway.exception;

/**
 * @ClassName: GatewayServiceException
 * @Package: com.wb.gateway.exception
 * @Description: the gateway service exception
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public class GatewayServiceException extends RuntimeException {

    /**
     * constructs a new gateway service exception with the specified message.
     *
     * @param message the message
     */
    public GatewayServiceException(String message) {
        super(message);
    }

    /**
     * constructs a new gateway service exception with the specified message and cause.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GatewayServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
