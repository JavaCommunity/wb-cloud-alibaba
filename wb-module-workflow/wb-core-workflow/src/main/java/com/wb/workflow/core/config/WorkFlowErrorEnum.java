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

    NO_SUPPORT_CMD("4441", "暂不支持该接口调用,请联系管理员！"),
    NOT_FOUND_CMD("4443", "未找到可执行命令！"),
    EXECUTE_CMD("4444", "执行命令异常！"),
    START_INSTANCE("4445", "启动流程失败！"),
    NOT_FOUND_INSTANCE("4446", "未找到流程实例！"),
    NOT_FOUND_EXECUTE_INSTANCE("4447", "未找到执行实例！"),
    NOT_FOUND_END_EVENT("33312", "未找到结束节点信息！"),
    NOT_FOUND_GROUP("333314", "未找到流程分组信息！"),
    DEFINITION_EXIST("33313", "流程定义已存在！"),
    GROUP_EXIST("33313", "流程分组已存在！"),
    CREATE_MODEL("33315", "创建模型失败！"),
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
