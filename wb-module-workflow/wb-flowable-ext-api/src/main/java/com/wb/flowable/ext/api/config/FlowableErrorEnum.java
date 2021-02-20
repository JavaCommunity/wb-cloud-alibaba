package com.wb.flowable.ext.api.config;

/**
 * @ClassName: FlowableErrorEnum
 * @Package: com.wb.flowable.ext.api.config
 * @Description: the flowable error enum
 * @Author：[bo.wang]
 * @Date: 2021/2/20
 * @Version: 1.0
 */
public enum FlowableErrorEnum {

    NOT_FOUND_INSTANCE("10001", "未找到流程流程实例！"),
    ;

    //  the error code
    private String code;

    //  the error message
    private String msg;

    /**
     * constructs a new flowableErrorEnum with the specified code and message.
     *
     * @param code the code
     * @param msg  the message
     */
    FlowableErrorEnum(String code, String msg) {
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
