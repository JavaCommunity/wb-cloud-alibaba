package com.wb.sms.component.command.request.aliyun;

import com.wb.sms.component.command.request.SmsGenericCmdRequest;
import com.wb.sms.component.command.result.aliyun.AliyunSendBatchSmsCmdResult;
import com.wb.sms.component.config.SmsCmdEnum;
import com.wb.sms.component.utils.SmsRequestCheckUtils;

/**
 * @ClassName: AliyunSendBatchSmsCmdRequest
 * @Package: com.wb.sms.component.command.request.aliyun
 * @Description: the aliyun send batch sms cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
public class AliyunSendBatchSmsCmdRequest extends SmsGenericCmdRequest<AliyunSendBatchSmsCmdResult> {

    //  the template param json
    private String templateParamJson;

    //  the sms up extend code json
    private String smsUpExtendCodeJson;

    //  the sign name json
    private String signNameJson;

    //  the template code
    private String templateCode;

    //  the phone number json
    private String phoneNumberJson;

    /**
     * constructs a new aliyun send batch sms cmd request.
     */
    public AliyunSendBatchSmsCmdRequest() {
        super(SmsCmdEnum.ALIYUN_SEND_BATCH_SMS.getName());
    }

    @Override
    public void check() {
        SmsRequestCheckUtils.checkEmpty(templateParamJson, "templateParamJson");
        SmsRequestCheckUtils.checkEmpty(signNameJson, "signNameJson");
        SmsRequestCheckUtils.checkEmpty(templateCode, "templateCode");
        SmsRequestCheckUtils.checkEmpty(phoneNumberJson, "phoneNumberJson");
    }

    public String getTemplateParamJson() {
        return templateParamJson;
    }

    public void setTemplateParamJson(String templateParamJson) {
        this.templateParamJson = templateParamJson;
    }

    public String getSmsUpExtendCodeJson() {
        return smsUpExtendCodeJson;
    }

    public void setSmsUpExtendCodeJson(String smsUpExtendCodeJson) {
        this.smsUpExtendCodeJson = smsUpExtendCodeJson;
    }

    public String getSignNameJson() {
        return signNameJson;
    }

    public void setSignNameJson(String signNameJson) {
        this.signNameJson = signNameJson;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getPhoneNumberJson() {
        return phoneNumberJson;
    }

    public void setPhoneNumberJson(String phoneNumberJson) {
        this.phoneNumberJson = phoneNumberJson;
    }
}
