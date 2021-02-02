package com.wb.oss.component.response;

import com.wb.oss.component.config.OssErrorCodeEnum;

/**
 * @ClassName: GenericResponse
 * @Package: com.wb.oss.component.response
 * @Description: the generic response
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class GenericResponse {

    //  the error code
    private String errCode;

    //  the error message
    private String errMsg;

    //  the body
    private String body;

    /**
     * constructs a new genericResponse
     */
    public GenericResponse() {
    }

    /**
     * constructs a new genericResponse with the specified error code and error message
     *
     * @param errCode the error code
     * @param errMsg  the error message
     */
    public GenericResponse(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     * the is success
     *
     * @return <tt>true<tt/> the oss operation success
     */
    public boolean isSuccess() {
        return OssErrorCodeEnum.SUCCESS.getErrCode().equals(this.errCode);
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
