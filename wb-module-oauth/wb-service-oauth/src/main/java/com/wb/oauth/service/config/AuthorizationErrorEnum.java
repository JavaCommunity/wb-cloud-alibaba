package com.wb.oauth.service.config;

/**
 * @ClassName: AuthorizationErrorEnum
 * @Package: com.wb.oauth.service.config
 * @Description: 认证中心错误枚举
 * @Author：[bo.wang]
 * @Date: 2021/4/25
 * @Version: 1.0
 */
public enum AuthorizationErrorEnum {

    USER_NOT_FOUND("0001", "用户不存在！"),
    USER_LOCK("0002", "用户已被锁定！"),
    USER_DISABLE("0003", "用户已被禁用！"),
    USER_DRAFT("0004", "用户处于暂存状态！"),
    INVALID_TOKEN("0005", "无效的TOKEN！"),
    INVALID_CODE("0006", "无效的授权码！"),
    ;

    /**
     * 错误码
     */
    private String errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    AuthorizationErrorEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
