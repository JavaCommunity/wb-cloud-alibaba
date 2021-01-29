package com.wb.oss.component.response;

import java.io.Serializable;

/**
 * @ClassName: OssResponse
 * @Package: com.wb.oss.component.response
 * @Description: the oss response
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class OssResponse implements Serializable {

    private static final long serialVersionUID = 7730167104129754490L;

    //  the error code
    private String errCode;

    //  the error message
    private String errMsg;

    //  the body
    private String body;

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
