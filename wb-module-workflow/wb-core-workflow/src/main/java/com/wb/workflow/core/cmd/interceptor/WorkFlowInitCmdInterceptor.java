package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowCmdRequest;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import com.wb.workflow.core.service.WorkFlowInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @ClassName: WorkFlowInitCmdInterceptor
 * @Package: com.wb.workflow.core.cmd.interceptor
 * @Description: the init cmd interceptor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowInitCmdInterceptor extends AbstractWorkFlowCmdInterceptor {

    @Autowired
    private WorkFlowDefinitionService definitionService;

    @Autowired
    private WorkFlowInstanceService instanceService;

    @Override
    public <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest) {
        if (!ObjectUtils.isEmpty(cmdRequest)) {
            //  init definition info
            initDefinition(cmdRequest);

            //  init instance info
            initInstance(cmdRequest);
        }
        return super.execute(cmd, cmdRequest);
    }

    @Override
    public int getOrder() {
        return 5;
    }

    /**
     * init work flow definition info.
     *
     * @param request the cmd request
     */
    private void initDefinition(WorkFlowCmdRequest request) {
        WorkFlowGenericCmdRequest genericRequest = (WorkFlowGenericCmdRequest) request;
        genericRequest.setDefinition(null);
        String definitionId = genericRequest.getDefinitionId();
        WorkFlowDefinitionEntity definitionEntity = null;
        String definitionCode = genericRequest.getDefinitionCode();
        if (!StringUtils.isEmpty(definitionId)) {
            definitionEntity = definitionService.queryForId(definitionId);
        } else if (!StringUtils.isEmpty(definitionCode) && ObjectUtils.isEmpty(definitionEntity)) {
            definitionEntity = definitionService.queryMainForCode(definitionCode);
        }
        genericRequest.setDefinition(definitionEntity);
    }

    /**
     * init work flow instance info.
     *
     * @param request the cmd request
     */
    private void initInstance(WorkFlowCmdRequest request) {
        WorkFlowGenericCmdRequest genericRequest = (WorkFlowGenericCmdRequest) request;
        String instanceId = genericRequest.getInstanceId();
        if (StringUtils.isEmpty(instanceId)) {
            return;
        }
        genericRequest.setInstance(null);
        WorkFlowInstanceEntity instanceEntity = instanceService.queryForId(instanceId);
        genericRequest.setInstance(instanceEntity);
    }
}
