package com.wb.workflow.core.config;

/**
 * @ClassName: WorkFlowErrorEnum
 * @Package: com.wb.workflow.core.config
 * @Description: the work flow error enum
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public enum WorkFlowErrorEnum {

    NOT_FOUND_CMD("4443", "未找到可执行命令！"),
    ;

    //  the error code
    private String code;

    //  the error message
    private String msg;

    /**
     * constructs a new workFlowErrorEnum with the specified code and message.
     *
     * @param code the code
     * @param msg  the message
     */
    WorkFlowErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
