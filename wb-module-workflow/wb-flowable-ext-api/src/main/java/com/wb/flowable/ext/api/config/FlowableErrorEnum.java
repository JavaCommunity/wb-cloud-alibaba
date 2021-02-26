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

    //  model
    MODEL_IS_NULL("10006", "请先绘制流程图！"),
    MODEL_ERROR("10006", "流程图错误！"),
    NOT_FOUND_MODEL("10005", "未找到流程模型！"),

    //  definition
    NOT_FOUND_DEFINITION("10002", "未找到流程定义信息！"),

    //  deployment
    NOT_FOUND_DEPLOYMENT("10003", "未找到流程部署信息！"),

    //  instance
    NOT_FOUND_INSTANCE("10001", "未找到流程实例！"),
    NOT_FOUND_EXECUTION_INSTANCE("10006", "未找到执行实例！"),
    START_INSTANCE("10004", "启动流程失败！"),

    //  task
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
