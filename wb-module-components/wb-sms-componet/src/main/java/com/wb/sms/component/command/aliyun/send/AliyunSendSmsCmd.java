package com.wb.sms.component.command.aliyun.send;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.wb.sms.component.command.aliyun.AliyunGenericSmsCmd;
import com.wb.sms.component.command.request.SmsCmdRequest;
import com.wb.sms.component.command.request.aliyun.AliyunSendSmsCmdRequest;
import com.wb.sms.component.command.result.aliyun.AliyunSendSmsCmdResult;
import com.wb.sms.component.config.SmsConstants;
import com.wb.sms.component.exception.SmsServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @ClassName: AliyunSendSmsCmd
 * @Package: com.wb.sms.component.command.aliyun.send
 * @Description: the aliyun send sms command
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
@Component
public class AliyunSendSmsCmd extends AliyunGenericSmsCmd {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(AliyunSendSmsCmd.class);

    @Autowired
    private IAcsClient acsClient;

    @Override
    public <T> T execute(SmsCmdRequest<T> cmdRequest) {
        AliyunSendSmsCmdRequest request = (AliyunSendSmsCmdRequest) cmdRequest;
        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        BeanUtils.copyProperties(request, sendSmsRequest);
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(sendSmsRequest);
        } catch (ClientException e) {
            log.error("[Sms Starter] Aliyun Send Sms Error,ErrMsg:{}", e.getErrMsg());
            throw new SmsServerException(e.getErrMsg());
        }
        String code = Optional.ofNullable(sendSmsResponse.getCode()).get();
        if (!SmsConstants.ALIYUN_SEND_SUCCESS_CODE.equals(code)) {
            throw new SmsServerException(sendSmsResponse.getMessage());
        }
        AliyunSendSmsCmdResult sendCmdResult = new AliyunSendSmsCmdResult();
        BeanUtils.copyProperties(sendSmsResponse, sendCmdResult);
        sendCmdResult.isOk();
        return (T) sendCmdResult;
    }
}
