package com.wb.sms.component.command.request.aliyun;

import com.wb.sms.component.command.request.SmsGenericCmdRequest;
import com.wb.sms.component.command.result.aliyun.AliyunSendSmsCmdResult;
import com.wb.sms.component.config.SmsCmdEnum;
import com.wb.sms.component.config.SmsErrorEnum;
import com.wb.sms.component.exception.SmsIllegalArgumentException;
import com.wb.sms.component.utils.SmsRequestCheckUtils;

/**
 * @ClassName: AliyunSendSmsCmdRequest
 * @Package: com.wb.sms.component.command.request.aliyun
 * @Description: the aliyun sms send cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class AliyunSendSmsCmdRequest extends SmsGenericCmdRequest<AliyunSendSmsCmdResult> {

    //  the default max phone number
    private static final int MAX_PHONE_NUMBER = 1000;

    //  必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,
    //  批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；
    //  发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
    private String phoneNumbers;

    //  必填:短信签名-可在短信控制台中找到
    private String signName;

    //  必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
    private String templateCode;

    //  可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
    //  友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
    //  参考：request.setTemplateParam("{\"变量1\":\"值1\",\"变量2\":\"值2\",\"变量3\":\"值3\"}")
    private String templateParam;

    //  可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
    private String smsUpExtendCode;

    //  可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
    private String outId;

    /**
     * constructs a new aliyun send sms cmd request.
     */
    public AliyunSendSmsCmdRequest() {
        super(SmsCmdEnum.ALIYUN_SEND_SMS.getName());
    }

    @Override
    public void check() {
        SmsRequestCheckUtils.checkEmpty(phoneNumbers, "phoneNumbers");
        SmsRequestCheckUtils.checkEmpty(signName, "signName");
        SmsRequestCheckUtils.checkEmpty(templateCode, "templateCode");
        String[] phoneNumberArray = phoneNumbers.split(",");
        if (phoneNumberArray.length > MAX_PHONE_NUMBER) {
            throw new SmsIllegalArgumentException(SmsErrorEnum.MAX_PHONE_NUMBER.getMsg());
        }
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getSmsUpExtendCode() {
        return smsUpExtendCode;
    }

    public void setSmsUpExtendCode(String smsUpExtendCode) {
        this.smsUpExtendCode = smsUpExtendCode;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }
}
