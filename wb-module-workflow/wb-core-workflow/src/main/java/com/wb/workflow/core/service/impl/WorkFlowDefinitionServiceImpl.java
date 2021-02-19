package com.wb.workflow.core.service.impl;

import com.wb.common.utils.entity.EntityUtils;
import com.wb.workflow.core.cmd.resolver.WorkFlowCmdResolver;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.config.WorkFlowPublishStatusEnum;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.exception.WorkFlowServiceException;
import com.wb.workflow.core.repository.WorkFlowDefinitionMapper;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import com.wb.workflow.core.vo.WorkFlowDefinitionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
    private WorkFlowDefinitionMapper definitionMapper;

    @Autowired
    private WorkFlowCmdResolver defaultCmdResolver;

    @Override
    public void save(WorkFlowDefinitionEntity definitionEntity) {
        EntityUtils.save(definitionEntity, WorkFlowContextHolder.getCurrentUser());
        definitionEntity.setIsMainVersion("1");
        definitionEntity.setVersion("1");
        definitionEntity.setPublishStatus(WorkFlowPublishStatusEnum.DRAFT.name());
        int saveNum = definitionMapper.save(definitionEntity);
        if (saveNum <= 0) {
            throw new WorkFlowServiceException("save workFlow definition info error！");
        }
    }

    @Override
    public WorkFlowDefinitionEntity update(WorkFlowDefinitionVo definitionVo) {
        return null;
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
}
