package com.wb.workflow.core.cmd.result;

/**
 * @ClassName: AbstractWorkFlowResult
 * @Package: com.wb.workflow.core.cmd.result
 * @Description: the work flow generic cmd result
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public class WorkFlowGenericCmdResult {

    //  the error code
    private String errCode;

    //  the error message
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
