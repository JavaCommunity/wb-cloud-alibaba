package com.wb.oss.component.config;

/**
 * @ClassName: OssErrorCodeEnum
 * @Package: com.wb.oss.component.config
 * @Description: the oss error code enum
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public enum OssErrorCodeEnum {

    SUCCESS("30001", "操作成功！"),
    FAIL("30002", "操作失败！");

    //  the error code
    private String errCode;

    //  the error message
    private String errMsg;

    /**
     * constructs a new OssErrorCodeEnum with the specified errCode and errMsg
     *
     * @param errCode the error code
     * @param errMsg  the error message
     */
    OssErrorCodeEnum(String errCode, String errMsg) {
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
