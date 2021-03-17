package com.wb.sms.component.command.result;

import com.wb.sms.component.config.SmsErrorEnum;

/**
 * @ClassName: SmsCmdResult
 * @Package: com.wb.sms.component.command.result
 * @Description: the sms result
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class SmsCmdResult {

    //  the error code
    protected String errCode;

    //  the error message
    protected String errMsg;

    /**
     * set err code and err message.
     */
    public void isOk() {
        this.errCode = SmsErrorEnum.SUCCESS.getCode();
        this.errMsg = SmsErrorEnum.SUCCESS.getMsg();
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
