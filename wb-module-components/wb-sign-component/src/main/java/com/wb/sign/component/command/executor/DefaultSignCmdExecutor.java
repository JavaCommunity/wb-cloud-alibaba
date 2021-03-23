package com.wb.sign.component.command.executor;

import com.wb.sign.component.command.SignCommand;
import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.result.SignResult;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @ClassName: DefaultSignCmdExecutor
 * @Package: com.wb.sign.component.command.executor
 * @Description: the default sign cmd executor
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Component
public class DefaultSignCmdExecutor implements SignCmdExecutor {

    @Override
    public <T extends SignResult> T execute(SignCommand cmd, SignRequest<T> signRequest) {
        Assert.notNull(signRequest, "'signRequest' must not be null！");

        //  the request check
        signRequest.check();

        //  the execute sign request
        return cmd.execute(signRequest);
    }
}
