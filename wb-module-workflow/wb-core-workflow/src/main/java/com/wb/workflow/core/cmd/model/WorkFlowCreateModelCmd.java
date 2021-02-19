package com.wb.workflow.core.cmd.model;

import com.wb.flowable.ext.api.model.FlowableModelExt;
import com.wb.flowable.ext.api.model.FlowableModelRequest;
import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.model.WorkFlowCreateModelCmdRequest;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.entity.WorkFlowGroupEntity;
import com.wb.workflow.core.exception.WorkFlowServiceException;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import com.wb.workflow.core.service.WorkFlowGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ClassName: WorkFlowCreateModelCmd
 * @Package: com.wb.workflow.core.cmd.model
 * @Description: the work flow create model cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowCreateModelCmd implements WorkFlowCmd {

    @Autowired
    private WorkFlowGroupService groupService;

    @Autowired
    private FlowableModelExt flowableModelExt;

    @Autowired
    private WorkFlowDefinitionService definitionService;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowCreateModelCmdRequest request = (WorkFlowCreateModelCmdRequest) cmdRequest;
        List<WorkFlowDefinitionEntity> workFlowDefinitionList = definitionService.queryForCode(request.getCode());
        if (!CollectionUtils.isEmpty(workFlowDefinitionList)) {
            throw new WorkFlowServiceException("workFlow definition exist！");
        }
        String groupId = request.getGroupId();
        WorkFlowGroupEntity groupEntity = groupService.queryForId(groupId);
        Assert.notNull(groupEntity, "not found workFlow group info,groupId:" + groupId);

        //  create flowable model
        FlowableModelRequest modelRequest = new FlowableModelRequest();
        BeanUtils.copyProperties(request, modelRequest);
        String fModelId = flowableModelExt.create(modelRequest);
        Assert.hasText(fModelId, "create model error！");

        //  save definition
        WorkFlowDefinitionEntity definitionEntity = new WorkFlowDefinitionEntity();
        BeanUtils.copyProperties(request, definitionEntity);
        definitionEntity.setfModelId(fModelId);
        definitionService.save(definitionEntity);
        return (T) definitionEntity.getId();
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowCreateModelCmdRequest.class;
    }
}
