package com.wb.workflow.core.service.impl;

import com.wb.common.utils.entity.EntityUtils;
import com.wb.flowable.ext.api.model.FlowableModelExt;
import com.wb.flowable.ext.api.model.FlowableModelRequest;
import com.wb.workflow.core.cmd.resolver.WorkFlowCmdResolver;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.exception.WorkFlowServiceException;
import com.wb.workflow.core.repository.WorkFlowDefinitionMapper;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import com.wb.workflow.core.vo.WorkFlowDefinitionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @ClassName: WorkFlowDefinitionServiceImpl
 * @Package: com.wb.workflow.core.service.impl
 * @Description: the work flow definition service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkFlowDefinitionServiceImpl implements WorkFlowDefinitionService {

    @Autowired
    private WorkFlowCmdResolver defaultCmdResolver;

    @Autowired
    private WorkFlowDefinitionMapper definitionMapper;

    @Autowired
    private FlowableModelExt modelExt;

    @Override
    public void save(WorkFlowDefinitionEntity definitionEntity) {
        EntityUtils.save(definitionEntity, WorkFlowContextHolder.getCurrentUser());
        int saveNum = definitionMapper.save(definitionEntity);
        if (saveNum <= 0) {
            throw new WorkFlowServiceException("save workFlow definition info error！");
        }
    }

    @Override
    public WorkFlowDefinitionEntity updateModel(WorkFlowDefinitionVo definitionVo) {
        Assert.notNull(definitionVo, "'definitionVo' must not be null！");
        WorkFlowDefinitionEntity definitionEntity = this.queryForId(definitionVo.getDefinitionId());
        if (ObjectUtils.isEmpty(definitionEntity)) {
            throw new WorkFlowServiceException(WorkFlowErrorEnum.DEFINITION_EXIST.getMsg());
        }

        //  validation bpmn model
        String jsonXml = definitionVo.getJson_xml();
        modelExt.validationBpmnModel(jsonXml);

        //  update model
        FlowableModelRequest modelRequest = new FlowableModelRequest(
                definitionEntity.getfModelId(),
                jsonXml,
                definitionVo.getSvg_xml()
        );
        modelExt.update(modelRequest);
        EntityUtils.save(definitionEntity, WorkFlowContextHolder.getCurrentUser());
        definitionEntity.setVersion(String.valueOf(Integer.valueOf(definitionEntity.getVersion()) + 1));
        int updateNum = definitionMapper.update(definitionEntity);
        if (updateNum < 1) {
            throw new WorkFlowServiceException("update definition info error！");
        }
        return definitionEntity;
    }

    @Override
    public WorkFlowDefinitionEntity queryForId(String definitionId) {
        Assert.hasLength(definitionId, "'definitionId' must not be null！");

        return definitionMapper.queryForId(definitionId);
    }

    @Override
    public List<WorkFlowDefinitionEntity> queryForCode(String definitionCode) {
        Assert.hasLength(definitionCode, "'definitionCode' must not be null！");

        return definitionMapper.queryForCode(definitionCode);
    }

    @Override
    public Object executeCmd(WorkFlowDefinitionVo definitionVo) {
        String cmdType = definitionVo.getCmdType();
        boolean support = defaultCmdResolver.support(cmdType);
        Assert.isTrue(support, WorkFlowErrorEnum.NO_SUPPORT_CMD.getMsg());

        return defaultCmdResolver.resolverCmdInvoke(cmdType, definitionVo);
    }

    @Override
    public void checkForCode(String definitionCode) {
        Assert.hasLength(definitionCode, "'definitionCode' must not be null！");

        List<WorkFlowDefinitionEntity> definitionEntityList = this.queryForCode(definitionCode);
        if (!CollectionUtils.isEmpty(definitionEntityList)) {
            throw new WorkFlowServiceException(WorkFlowErrorEnum.DEFINITION_EXIST.getMsg());
        }
    }

    @Override
    public void checkForId(String definitionId) {
        Assert.hasLength(definitionId, "'definitionId' must not be null！");

        WorkFlowDefinitionEntity definitionEntity = this.queryForId(definitionId);
        if (ObjectUtils.isEmpty(definitionEntity)) {
            throw new WorkFlowServiceException(WorkFlowErrorEnum.DEFINITION_EXIST.getMsg());
        }
    }
}
