package com.wb.workflow.core.cmd.resolver;

/**
 * @ClassName: WorkFlowCmdResolver
 * @Package: com.wb.workflow.core.cmd.resolver
 * @Description: the work flow cmd resolver
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public interface WorkFlowCmdResolver {

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
     * @param reqObj  the request object
     * @return the cmd execute return
     */
    Object resolverCmdInvoke(String cmdType, Object reqObj);
}
