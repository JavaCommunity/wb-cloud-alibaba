package com.wb.sms.component.command.result.aliyun;

import com.wb.sms.component.command.result.SmsCmdResult;

/**
 * @ClassName: AliyunSendSmsCmdResult
 * @Package: com.wb.sms.component.command.result.aliyun
 * @Description: the aliyun sms send cmd result
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class AliyunSendSmsCmdResult extends SmsCmdResult {

    //  the request id
    private String requestId;

    //  the biz id
    private String bizId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
