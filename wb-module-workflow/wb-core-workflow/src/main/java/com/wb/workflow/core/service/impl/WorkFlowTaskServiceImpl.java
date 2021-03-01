package com.wb.workflow.core.service.impl;

import com.wb.flowable.ext.api.task.FlowableTaskExt;
import com.wb.workflow.core.cmd.resolver.WorkFlowCmdResolver;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.service.WorkFlowTaskService;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;
import com.wb.workflow.core.vo.WorkFlowTaskVo;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @ClassName: WorkFlowTaskServiceImpl
 * @Package: com.wb.workflow.core.service.impl
 * @Description: the work flow task service impl
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Service
public class WorkFlowTaskServiceImpl implements WorkFlowTaskService {

    @Autowired
    private WorkFlowCmdResolver defaultCmdResolver;

    @Autowired
    private FlowableTaskExt taskExt;

    @Override
    public Object executeCmd(WorkFlowTaskVo taskVo) {
        String cmdType = taskVo.getCmdType();
        boolean support = defaultCmdResolver.support(cmdType);
        Assert.isTrue(support, WorkFlowErrorEnum.NO_SUPPORT_CMD.getMsg());

        return defaultCmdResolver.resolverCmdInvoke(cmdType, taskVo);
    }

    @Override
    public Task queryForId(String taskId) {
        WorkFlowReqCheckUtils.checkEmpty(taskId, "taskId");

        return taskExt.queryForId(taskId);
    }
}
