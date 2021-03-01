package com.wb.workflow.core.cmd.definition;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.executor.WorkFlowExecutor;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.definition.WorkFlowCreateDefinitionCmdRequest;
import com.wb.workflow.core.cmd.request.model.WorkFlowCreateModelCmdRequest;
import com.wb.workflow.core.config.WorkFlowCmdEnum;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.config.WorkFlowDefinitionStatusEnum;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.exception.WorkFlowException;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import com.wb.workflow.core.service.WorkFlowGroupService;
import com.wb.workflow.core.utils.WorkFlowCmdUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @ClassName: WorkFlowCreateDefinitionCmd
 * @Package: com.wb.workflow.core.cmd.definition
 * @Description: the work flow definition cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/26
 * @Version: 1.0
 */
@Component
public class WorkFlowCreateDefinitionCmd implements WorkFlowCmd {

    @Autowired
    private WorkFlowGroupService groupService;

    @Autowired
    private WorkFlowDefinitionService definitionService;

    @Autowired
    private WorkFlowExecutor defaultExecutor;

    @Override
    public void check(WorkFlowGenericCmdRequest cmdRequest) {
        WorkFlowCreateDefinitionCmdRequest request = (WorkFlowCreateDefinitionCmdRequest) cmdRequest;
        definitionService.checkForCode(request.getCode());
        groupService.checkForId(request.getGroupId());
    }

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowCreateDefinitionCmdRequest request = (WorkFlowCreateDefinitionCmdRequest) cmdRequest;

        WorkFlowCmd command = WorkFlowCmdUtils.getOptionalCmd(WorkFlowCmdEnum.CREATE_MODEL);
        WorkFlowCreateModelCmdRequest modelRequest = new WorkFlowCreateModelCmdRequest();
        BeanUtils.copyProperties(request, modelRequest);
        String modelId = defaultExecutor.execute(command, modelRequest);
        if (!StringUtils.hasText(modelId)) {
            throw new WorkFlowException(WorkFlowErrorEnum.CREATE_MODEL.getMsg());
        }

        //  the save definition
        WorkFlowDefinitionEntity definitionEntity = new WorkFlowDefinitionEntity();
        BeanUtils.copyProperties(cmdRequest, definitionEntity);
        definitionEntity.setIsMainVersion("1");
        definitionEntity.setVersion("1");
        definitionEntity.setfModelId(modelId);
        definitionEntity.setStatus(WorkFlowDefinitionStatusEnum.DRAFT.name());
        definitionService.save(definitionEntity);
        return (T) definitionEntity.getId();
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowCreateDefinitionCmdRequest.class;
    }
}
