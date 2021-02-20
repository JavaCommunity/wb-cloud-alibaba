package com.wb.workflow.core.service.impl;

import com.wb.common.utils.entity.EntityUtils;
import com.wb.workflow.core.cmd.resolver.WorkFlowCmdResolver;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.entity.WorkFlowGroupEntity;
import com.wb.workflow.core.exception.WorkFlowServiceException;
import com.wb.workflow.core.repository.WorkFlowGroupMapper;
import com.wb.workflow.core.service.WorkFlowGroupService;
import com.wb.workflow.core.vo.WorkFlowGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @ClassName: WorkFlowGroupServiceImpl
 * @Package: com.wb.workflow.core.service.impl
 * @Description: the work flow group service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkFlowGroupServiceImpl implements WorkFlowGroupService {

    @Autowired
    private WorkFlowGroupMapper groupMapper;

    @Autowired
    private WorkFlowCmdResolver defaultCmdResolver;

    @Override
    public WorkFlowGroupEntity queryForId(String groupId) {
        Assert.hasLength(groupId, "'groupId' must not be null！");

        return groupMapper.queryForId(groupId);
    }

    @Override
    public Object executeCmd(WorkFlowGroupVo groupVo) {
        String cmdType = groupVo.getCmdType();
        boolean support = defaultCmdResolver.support(cmdType);
        Assert.isTrue(support, WorkFlowErrorEnum.NO_SUPPORT_CMD.getMsg());

        return defaultCmdResolver.resolverCmdInvoke(cmdType, groupVo);
    }

    @Override
    public void save(WorkFlowGroupEntity groupEntity) {
        EntityUtils.save(groupEntity, WorkFlowContextHolder.getCurrentUser());
        int saveNum = groupMapper.save(groupEntity);
        if (saveNum <= 0) {
            throw new WorkFlowServiceException("save workFlow group info error！");
        }
    }
}
