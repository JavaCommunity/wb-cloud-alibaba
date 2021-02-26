package com.wb.workflow.core.service.impl;

import com.wb.common.utils.entity.EntityUtils;
import com.wb.workflow.core.cmd.resolver.WorkFlowCmdResolver;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import com.wb.workflow.core.exception.WorkFlowException;
import com.wb.workflow.core.repository.WorkFlowInstanceMapper;
import com.wb.workflow.core.service.WorkFlowInstanceService;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;
import com.wb.workflow.core.vo.WorkFlowInstanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @ClassName: WorkFlowInstanceServiceImpl
 * @Package: com.wb.workflow.core.service.impl
 * @Description: the work flow instance service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkFlowInstanceServiceImpl implements WorkFlowInstanceService {

    @Autowired
    private WorkFlowInstanceMapper instanceMapper;

    @Autowired
    private WorkFlowCmdResolver defaultCmdResolver;

    @Override
    public void save(WorkFlowInstanceEntity instance) {
        WorkFlowReqCheckUtils.checkEmpty(instance, "instance");

        EntityUtils.save(instance, WorkFlowContextHolder.getCurrentUser());
        int saveNum = instanceMapper.save(instance);
        if (saveNum < 1) {
            throw new WorkFlowException("save workFlow instance info error!");
        }
    }

    @Override
    public Object executeCmd(WorkFlowInstanceVo instanceVo) {
        String cmdType = instanceVo.getCmdType();
        boolean support = defaultCmdResolver.support(cmdType);
        Assert.isTrue(support, WorkFlowErrorEnum.NO_SUPPORT_CMD.getMsg());

        return defaultCmdResolver.resolverCmdInvoke(cmdType, instanceVo);
    }
}
