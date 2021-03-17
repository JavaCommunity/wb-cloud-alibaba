package com.wb.sms.example.controller;

import com.wb.sms.component.client.SmsClient;
import com.wb.sms.component.command.request.aliyun.AliyunSendSmsCmdRequest;
import com.wb.sms.component.command.result.aliyun.AliyunSendSmsCmdResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AliyunSmsController
 * @Package: com.wb.sms.example.controller
 * @Description: the aliyun sms controller
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "aliyun/sms/")
public class AliyunSmsController {

    @Autowired
    private SmsClient smsClient;

    @PostMapping(value = "send")
    public AliyunSendSmsCmdResult send(@RequestBody AliyunSendSmsCmdRequest request) {
        AliyunSendSmsCmdResult result = smsClient.execute(request);
        return result;
    }
}
