package com.wb.workflow.service.service.impl;

import com.wb.common.utils.entity.EntityUtils;
import com.wb.flowable.ext.api.model.FlowableModelExt;
import com.wb.flowable.ext.api.model.FlowableModelRequest;
import com.wb.workflow.core.config.WorkFlowPublishStatusEnum;
import com.wb.workflow.service.config.WorkFlowContextHolder;
import com.wb.workflow.service.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.service.entity.WorkFlowGroupEntity;
import com.wb.workflow.service.exception.WorkFlowServiceException;
import com.wb.workflow.service.repository.WorkFlowDefinitionMapper;
import com.wb.workflow.service.service.WorkFlowDefinitionService;
import com.wb.workflow.service.service.WorkFlowGroupService;
import com.wb.workflow.service.vo.WorkFlowDefinitionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ClassName: WorkFlowDefinitionServiceImpl
 * @Package: com.wb.workflow.service.service.impl
 * @Description: the work flow definition service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkFlowDefinitionServiceImpl implements WorkFlowDefinitionService {

    @Autowired
    private WorkFlowGroupService groupService;

    @Autowired
    private FlowableModelExt flowableModelExt;

    @Autowired
    private WorkFlowDefinitionMapper definitionMapper;

    @Override
    public WorkFlowDefinitionEntity save(WorkFlowDefinitionVo definitionVo) {
        Assert.notNull(definitionVo, "'definitionVo' must not be null！");
        String code = definitionVo.getCode();
        List<WorkFlowDefinitionEntity> workFlowDefinitionList = this.queryForCode(code);
        if (!CollectionUtils.isEmpty(workFlowDefinitionList)) {
            throw new WorkFlowServiceException("workFlow definition exist！");
        }
        String groupId = definitionVo.getGroupId();
        WorkFlowGroupEntity workFlowGroupEntity = groupService.queryForId(groupId);
        Assert.notNull(workFlowGroupEntity, "not found workFlow group info,groupId:" + groupId);

        //  create flowable model
        FlowableModelRequest request = new FlowableModelRequest();
        BeanUtils.copyProperties(definitionVo, request);
        String fModelId = flowableModelExt.create(request);
        Assert.hasText(fModelId, "create model error！");

        //  save definition
        WorkFlowDefinitionEntity definitionEntity = new WorkFlowDefinitionEntity();
        BeanUtils.copyProperties(definitionVo, definitionEntity);
        EntityUtils.save(definitionEntity, WorkFlowContextHolder.getCurrentUser());
        definitionEntity.setIsMainVersion("1");
        definitionEntity.setVersion("1");
        definitionEntity.setfModelId(fModelId);
        definitionEntity.setPublishStatus(WorkFlowPublishStatusEnum.DRAFT.name());
        int saveNum = definitionMapper.save(definitionEntity);
        if (saveNum <= 0) {
            throw new WorkFlowServiceException("save workFlow definition info error！");
        }
        return definitionEntity;
    }

    @Override
    public WorkFlowDefinitionEntity update(WorkFlowDefinitionVo definitionVo) {
        return null;
    }

    @Override
    public WorkFlowDefinitionEntity queryForId(String definitionId) {
        return null;
    }

    @Override
    public List<WorkFlowDefinitionEntity> queryForCode(String definitionCode) {
        return null;
    }
}
