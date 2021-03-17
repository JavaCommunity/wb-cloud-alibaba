package com.wb.sms.component.client;

import com.wb.sms.component.command.request.SmsCmdRequest;
import com.wb.sms.component.command.request.SmsGenericCmdRequest;
import com.wb.sms.component.command.resolver.SmsCmdResolver;
import com.wb.sms.component.config.SmsErrorEnum;
import com.wb.sms.component.exception.SmsServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @ClassName: DefaultSmsClient
 * @Package: com.wb.sms.component.client
 * @Description: the default sms client
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
@Component
public class DefaultSmsClient implements SmsClient {

    @Autowired
    private SmsCmdResolver smsCmdResolver;

    @Override
    public <T> T execute(SmsCmdRequest<T> request) {
        SmsGenericCmdRequest cmdRequest = (SmsGenericCmdRequest) request;
        String action = cmdRequest.getAction();
        if (StringUtils.isEmpty(action)) {
            throw new SmsServerException(SmsErrorEnum.SYSTEM.getMsg());
        }
        boolean support = smsCmdResolver.support(action);
        if (!support) {
            throw new SmsServerException(SmsErrorEnum.SYSTEM.getMsg());
        }
        return (T) smsCmdResolver.resolverCmdInvoke(action, request);
    }
}
