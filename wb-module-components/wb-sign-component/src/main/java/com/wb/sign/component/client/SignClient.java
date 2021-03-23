package com.wb.sign.component.client;

import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: SignClient
 * @Package: com.wb.sign.component.client
 * @Description: the sign client
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public interface SignClient {

    /**
     * execute cmd withe sign request.
     *
     * @param signRequest the sign request
     * @param <T>
     * @return the execute cmd result
     */
    <T extends SignResult> T execute(SignRequest<T> signRequest);
}
