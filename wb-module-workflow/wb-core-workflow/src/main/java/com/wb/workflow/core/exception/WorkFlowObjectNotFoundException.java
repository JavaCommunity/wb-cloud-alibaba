package com.wb.workflow.core.exception;

/**
 * @ClassName: WorkFlowObjectNotFoundException
 * @Package: com.wb.workflow.core.exception
 * @Description: the work flow object not found exception
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public class WorkFlowObjectNotFoundException extends WorkFlowException {

    //  the serial version uid
    private static final long serialVersionUID = 1L;

    //  the exception class
    private Class<?> cls;

    /**
     * constructs a new workFlowObjectNotFoundException with the specified message and class.
     *
     * @param message the message
     * @param cls     the class
     */
    public WorkFlowObjectNotFoundException(String message, Class<?> cls) {
        super(message);
        this.cls = cls;
    }

    /**
     * constructs a new workFlowObjectNotFoundException with the specified message and class and cause.
     *
     * @param message the message
     * @param cls     the class
     * @param cause   the cause
     */
    public WorkFlowObjectNotFoundException(String message, Class<?> cls, Throwable cause) {
        super(message, cause);
        this.cls = cls;
    }
}
