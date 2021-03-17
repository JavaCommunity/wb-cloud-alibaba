package com.wb.sms.component.command.executor;

import com.wb.sms.component.command.SmsCommand;
import com.wb.sms.component.command.request.SmsCmdRequest;
import com.wb.sms.component.config.SmsErrorEnum;
import com.wb.sms.component.exception.SmsServerException;
import com.wb.sms.component.utils.SmsRequestCheckUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: DefaultSmsCmdExecutor
 * @Package: com.wb.sms.component.command.executor
 * @Description: the default sms cmd executor
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
@Component
public class DefaultSmsCmdExecutor implements SmsCmdExecutor {

    @Override
    public <T> T execute(SmsCommand cmd, SmsCmdRequest<T> cmdRequest) {
        if (ObjectUtils.isEmpty(cmd)) {
            throw new SmsServerException(SmsErrorEnum.SYSTEM.getMsg());
        }
        SmsRequestCheckUtils.checkEmpty(cmdRequest, "cmdRequest");

        //  the cmd request check
        cmdRequest.check();

        //  the cmd execute before
        cmd.before(cmdRequest);

        //  the cmd execute
        T result = cmd.execute(cmdRequest);

        //  the cmd execute after
        cmd.after(cmdRequest);
        return result;
    }
}
