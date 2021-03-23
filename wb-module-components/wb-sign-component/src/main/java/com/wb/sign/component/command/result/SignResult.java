package com.wb.sign.component.command.result;

/**
 * @ClassName: SignResult
 * @Package: com.wb.sign.component.result
 * @Description: the sign result
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class SignResult {

    //  the err code
    private String errCode;

    //  the err msg
    private String errMsg;

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
