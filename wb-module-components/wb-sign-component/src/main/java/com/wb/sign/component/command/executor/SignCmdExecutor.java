package com.wb.sign.component.command.executor;

import com.wb.sign.component.command.SignCommand;
import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: SignCmdExecutor
 * @Package: com.wb.sign.component.command.exceutor
 * @Description: the sign cmd executor
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public interface SignCmdExecutor {

    /**
     * execute cmd with the cmd and sign request.
     *
     * @param cmd         the cmd
     * @param signRequest the sign request
     * @param <T>
     * @return the execute cmd result
     */
    <T  extends SignResult> T execute(SignCommand cmd, SignRequest<T> signRequest);
}
