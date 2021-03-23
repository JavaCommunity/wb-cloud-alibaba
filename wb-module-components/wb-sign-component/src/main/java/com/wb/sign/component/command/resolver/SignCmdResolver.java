package com.wb.sign.component.command.resolver;

import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: SignCmdResolver
 * @Package: com.wb.sign.component.command.resolver
 * @Description: the sign cmd resolver
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public interface SignCmdResolver {

    /**
     * check is support with the specified action
     *
     * @param action the action
     * @return <tt>true<tt/> if support
     */
    boolean isSupport(String action);

    /**
     * resolver cmd invoke with the specified action and request object
     *
     * @param action  the action
     * @param request the sign request
     * @return the cmd execute return
     */
    <T extends SignResult> T resolverCmdInvoke(String action, SignRequest<T> request);
}
