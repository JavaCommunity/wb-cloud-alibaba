package com.wb.workflow.core.exception;

/**
 * @ClassName: WorkFlowIllegalArgumentException
 * @Package: com.wb.workflow.core.exception
 * @Description: the work flow illegal argument exception
 * @Author：[bo.wang]
 * @Date: 2021/2/20
 * @Version: 1.0
 */
public class WorkFlowIllegalArgumentException extends WorkFlowException {

    /**
     * constructs a new workFlowIllegalArgumentException with the specified message.
     *
     * @param message the message
     */
    public WorkFlowIllegalArgumentException(String message) {
        super(message);
    }

    /**
     * constructs a new workFlowIllegalArgumentException with the specified message amd cause.
     *
     * @param message the message
     * @param cause the cause
     */
    public WorkFlowIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
