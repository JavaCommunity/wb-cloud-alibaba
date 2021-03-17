package com.wb.sms.component.command.executor;

import com.wb.sms.component.command.SmsCommand;
import com.wb.sms.component.command.request.SmsCmdRequest;

/**
 * @ClassName: SmsCmdExecutor
 * @Package: com.wb.sms.component.command.executor
 * @Description: the sms cmd executor
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
public interface SmsCmdExecutor {

    /**
     * execute cmd
     *
     * @param cmd        the cmd
     * @param cmdRequest the cmd request
     * @param <T>
     * @return the execute cmd result
     */
    <T> T execute(SmsCommand cmd, SmsCmdRequest<T> cmdRequest);
}
