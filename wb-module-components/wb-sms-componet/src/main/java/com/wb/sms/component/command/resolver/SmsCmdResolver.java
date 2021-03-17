package com.wb.sms.component.command.resolver;

import com.wb.sms.component.command.request.SmsCmdRequest;

/**
 * @ClassName: SmsCmdResolver
 * @Package: com.wb.sms.component.command.resolver
 * @Description: the sms cmd resolver
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
public interface SmsCmdResolver {

    /**
     * check is support with the specified cmd type
     *
     * @param cmdType the cmd type
     * @return <tt>true<tt/> if support
     */
    boolean support(String cmdType);

    /**
     * resolver cmd invoke with the specified cmd type and request object
     *
     * @param cmdType the cmd type
     * @param request the cmd request
     * @return the cmd execute return
     */
    <T> T resolverCmdInvoke(String cmdType, SmsCmdRequest<T> request);
}
