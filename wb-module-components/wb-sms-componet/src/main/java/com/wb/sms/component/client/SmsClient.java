package com.wb.sms.component.client;

import com.wb.sms.component.command.request.SmsCmdRequest;

/**
 * @ClassName: SmsClient
 * @Package: com.wb.sms.component.client
 * @Description: the sms client
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
public interface SmsClient {

    /**
     * the execute sms request
     *
     * @param request the sms request
     * @param <T>
     * @return the execute sms request result
     */
    <T> T execute(SmsCmdRequest<T> request);
}
