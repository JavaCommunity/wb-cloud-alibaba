package com.wb.workflow.service.exception;

/**
 * @ClassName: WorkFlowServiceException
 * @Package: com.wb.workflow.service.exception
 * @Description: the work flow service exception
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowServiceException extends RuntimeException {

    /**
     * constructs a new workFlow service exception with the specified message
     *
     * @param message the message
     */
    public WorkFlowServiceException(String message) {
        super(message);
    }

    /**
     * constructs a new workFlow service exception with the specified message and cause
     *
     * @param message the message
     * @param cause   the cause
     */
    public WorkFlowServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
