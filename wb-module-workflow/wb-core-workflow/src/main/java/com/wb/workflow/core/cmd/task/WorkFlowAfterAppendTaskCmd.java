package com.wb.workflow.core.cmd.task;

import com.wb.flowable.ext.api.config.FlowableAppendSignEnum;
import com.wb.flowable.ext.api.task.FlowableTaskExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowAfterAppendTaskCmdRequest;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @ClassName: WorkFlowAfterAppendTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow after append task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowAfterAppendTaskCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private FlowableTaskExt taskExt;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowAfterAppendTaskCmdRequest request = (WorkFlowAfterAppendTaskCmdRequest) cmdRequest;

        String userId = request.getUserId();
        if (StringUtils.isEmpty(userId)) {
            userId = WorkFlowContextHolder.getCurrentUserId();
        }
        taskExt.appendSign(userId, request.getTask(), request.getByAppendUser(), FlowableAppendSignEnum.BEFORE);
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowAfterAppendTaskCmdRequest.class;
    }
}
