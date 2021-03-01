package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import com.wb.workflow.core.service.WorkFlowInstanceService;
import com.wb.workflow.core.service.WorkFlowTaskService;
import org.flowable.task.api.Task;
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

    @Autowired
    private WorkFlowTaskService taskService;

    @Override
    public <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest) {
        if (!ObjectUtils.isEmpty(cmdRequest)) {
            WorkFlowGenericCmdRequest genericRequest = (WorkFlowGenericCmdRequest) cmdRequest;
            //  init definition info
            initDefinition(genericRequest);

            //  init instance info
            initInstance(genericRequest);

            //  init task info
            initTask(genericRequest);
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
     * @param cmdRequest the cmd request
     */
    private void initDefinition(WorkFlowGenericCmdRequest cmdRequest) {
        cmdRequest.setDefinition(null);
        String definitionId = cmdRequest.getDefinitionId();
        WorkFlowDefinitionEntity definitionEntity = null;
        String definitionCode = cmdRequest.getDefinitionCode();
        if (!StringUtils.isEmpty(definitionId)) {
            definitionEntity = definitionService.queryForId(definitionId);
        } else if (!StringUtils.isEmpty(definitionCode) && ObjectUtils.isEmpty(definitionEntity)) {
            definitionEntity = definitionService.queryMainForCode(definitionCode);
        }
        cmdRequest.setDefinition(definitionEntity);
    }

    /**
     * init work flow instance info.
     *
     * @param cmdRequest the cmd request
     */
    private void initInstance(WorkFlowGenericCmdRequest cmdRequest) {
        String instanceId = cmdRequest.getInstanceId();
        if (StringUtils.isEmpty(instanceId)) {
            return;
        }
        cmdRequest.setInstance(null);
        WorkFlowInstanceEntity instanceEntity = instanceService.queryForId(instanceId);
        cmdRequest.setInstance(instanceEntity);
    }

    /**
     * init work flow task info.
     *
     * @param cmdRequest the cmd request
     */
    private void initTask(WorkFlowGenericCmdRequest cmdRequest) {
        String taskId = cmdRequest.getTaskId();
        if (StringUtils.isEmpty(taskId)) {
            return;
        }
        cmdRequest.setInstance(null);
        Task task = taskService.queryForId(taskId);
        cmdRequest.setTask(task);
    }
}
