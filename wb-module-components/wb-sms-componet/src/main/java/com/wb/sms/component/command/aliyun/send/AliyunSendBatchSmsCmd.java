package com.wb.sms.component.command.aliyun.send;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendBatchSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendBatchSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.wb.sms.component.command.aliyun.AliyunGenericSmsCmd;
import com.wb.sms.component.command.request.SmsCmdRequest;
import com.wb.sms.component.command.request.aliyun.AliyunSendBatchSmsCmdRequest;
import com.wb.sms.component.command.result.aliyun.AliyunSendBatchSmsCmdResult;
import com.wb.sms.component.config.SmsConstants;
import com.wb.sms.component.exception.SmsServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @ClassName: AliyunSendBatchSmsCmd
 * @Package: com.wb.sms.component.command.aliyun.send
 * @Description: the aliyun send batch sms cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
@Component
public class AliyunSendBatchSmsCmd extends AliyunGenericSmsCmd {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(AliyunSendBatchSmsCmd.class);

    @Autowired
    private IAcsClient acsClient;

    @Override
    public <T> T execute(SmsCmdRequest<T> cmdRequest) {
        AliyunSendBatchSmsCmdRequest request = (AliyunSendBatchSmsCmdRequest) cmdRequest;
        SendBatchSmsRequest smsRequest = new SendBatchSmsRequest();
        BeanUtils.copyProperties(request, smsRequest);
        SendBatchSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(smsRequest);
        } catch (ClientException e) {
            log.error("[Sms Starter] Aliyun Send Batch Sms Error,ErrMsg:{}", e.getErrMsg());
            throw new SmsServerException(e.getErrMsg());
        }
        String code = Optional.ofNullable(sendSmsResponse.getCode()).get();
        if (!SmsConstants.ALIYUN_SEND_SUCCESS_CODE.equals(code)) {
            throw new SmsServerException(sendSmsResponse.getMessage());
        }
        AliyunSendBatchSmsCmdResult sendCmdResult = new AliyunSendBatchSmsCmdResult();
        BeanUtils.copyProperties(sendSmsResponse, sendCmdResult);
        sendCmdResult.isOk();
        return (T) sendCmdResult;
    }
}
