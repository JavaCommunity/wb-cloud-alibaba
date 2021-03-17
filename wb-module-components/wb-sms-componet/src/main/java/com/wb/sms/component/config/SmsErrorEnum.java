package com.wb.sms.component.config;

/**
 * @ClassName: SmsErrorEnum
 * @Package: com.wb.sms.component.config
 * @Description: the sms error enum
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public enum SmsErrorEnum {

    SUCCESS("00001", "操作成功！"),
    FAIL("00002", "操作失败！"),
    CONFIG("00003", "请正确配置Sms！"),
    MAX_PHONE_NUMBER("00004", "手机号码超出最大限制！"),
    ALIYUN("0005", "阿里云SMS服务异常，请稍后重试！"),
    SYSTEM("0006", "内部错误，请联系管理员！"),
    ;

    //  the error code
    private String code;

    //  the error message
    private String msg;

    /**
     * constructs a new sms error enum with the code and message.
     *
     * @param code the code
     * @param msg  the message
     */
    SmsErrorEnum(String code, String msg) {
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
