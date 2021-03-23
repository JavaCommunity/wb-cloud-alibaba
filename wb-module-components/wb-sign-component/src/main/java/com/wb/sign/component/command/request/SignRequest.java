package com.wb.sign.component.command.request;

import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: SignRequest
 * @Package: com.wb.sign.component.request
 * @Description: the sign request
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public interface SignRequest<T extends SignResult> {

    /**
     * check params
     */
    default void check() {

    }
}
