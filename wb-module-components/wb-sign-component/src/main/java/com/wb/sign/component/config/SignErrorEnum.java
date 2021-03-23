package com.wb.sign.component.config;

/**
 * @ClassName: SignErrorEnum
 * @Package: com.wb.sign.component.config
 * @Description: the sign error enum
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public enum SignErrorEnum {

    SUCCESS("10000", "操作成功！"),
    E_BAO_SYSTEM("10001", "e宝服务异常！"),
    E_BAO_API("10002", "e宝API异常！"),
    INTERNAL("4444", "内部异常，请联系管理员！"),
    ;

    //  the error code
    private String code;

    //  the error message
    private String msg;

    /**
     * constructs a new sign error enum with the specified code and message.
     *
     * @param code the code
     * @param msg  the message
     */
    SignErrorEnum(String code, String msg) {
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
