package com.wb.workflow.core.cmd.resolver;

import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.executor.WorkFlowExecutor;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.model.WorkFlowCreateModelCmdRequest;
import com.wb.workflow.core.config.WorkFlowCmdEnum;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.exception.WorkFlowObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: DefaultWorkFlowCmdResolver
 * @Package: com.wb.workflow.core.cmd.resolver
 * @Description: the default work flow cmd resolver
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
@Component
public class DefaultWorkFlowCmdResolver implements WorkFlowCmdResolver {

    @Autowired
    private WorkFlowExecutor defaultExecutor;

    @Override
    public boolean support(String cmdType) {
        return WorkFlowCmdEnum.isSupport(cmdType);
    }

    @Override
    public Object resolverCmdInvoke(String cmdType, Object reqObj) {
        String beanId = WorkFlowCmdEnum.getBeanId(cmdType);
        Assert.hasLength(beanId, WorkFlowErrorEnum.NOT_FOUND_CMD.getMsg());

        Object bean = SpringApplicationContextProvider.getBean(beanId);
        if (ObjectUtils.isEmpty(bean) || !(bean instanceof WorkFlowCmd)) {
            throw new WorkFlowObjectNotFoundException(WorkFlowErrorEnum.NOT_FOUND_CMD.getMsg(), DefaultWorkFlowCmdResolver.class);
        }

        WorkFlowCreateModelCmdRequest cmdRequest = new WorkFlowCreateModelCmdRequest();
        return defaultExecutor.execute((WorkFlowCmd) bean, (WorkFlowGenericCmdRequest) cmdRequest);
    }
}
