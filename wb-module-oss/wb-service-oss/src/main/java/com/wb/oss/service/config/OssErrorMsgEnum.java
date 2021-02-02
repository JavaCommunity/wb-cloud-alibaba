package com.wb.oss.service.config;

/**
 * @ClassName: OssErrorMsgEnum
 * @Package: com.wb.oss.service.config
 * @Description: the oss error message enum
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public enum OssErrorMsgEnum {

    FILE_SINGLE_UPLOAD("20001", "文件上传失败！"),
    FILE_SINGLE_DOWNLOAD("20002", "文件下载失败");

    //  the error code
    private String errCode;

    //  the error message
    private String errMsg;

    /**
     * constructs a new ossErrorMsgEnum with the specified error code and error message
     *
     * @param errCode the error code
     * @param errMsg  the error message
     */
    OssErrorMsgEnum(String errCode, String errMsg) {
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
