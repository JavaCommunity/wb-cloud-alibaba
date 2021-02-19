package com.wb.workflow.core.exception;

/**
 * @ClassName: WorkFlowException
 * @Package: com.wb.workflow.core.exception
 * @Description: the work flow exception
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public class WorkFlowException extends RuntimeException {

    //  the serial version uid
    private static final long serialVersionUID = 1L;

    /**
     * constructs a new workFlowException with the specified message.
     *
     * @param message the message
     */
    public WorkFlowException(String message) {
        super(message);
    }

    /**
     * constructs a new workFlowException with the specified message and cause.
     *
     * @param message the message
     * @param cause   the cause
     */
    public WorkFlowException(String message, Throwable cause) {
        super(message, cause);
    }
}
