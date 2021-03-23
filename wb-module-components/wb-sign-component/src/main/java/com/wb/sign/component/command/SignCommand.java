package com.wb.sign.component.command;

import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: SignCommand
 * @Package: com.wb.sign.component.cmd
 * @Description: the sign command
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public interface SignCommand {

    /**
     * execute sign command with the specified sign request
     *
     * @param signRequest the sign request
     * @param <T>
     * @return the execute command result
     */
    <T extends SignResult> T execute(SignRequest<T> signRequest);
}
