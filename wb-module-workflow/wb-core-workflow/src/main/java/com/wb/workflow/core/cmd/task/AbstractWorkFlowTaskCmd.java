package com.wb.workflow.core.cmd.task;

import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowAddTaskOperationCmdRequest;
import com.wb.workflow.core.cmd.resolver.WorkFlowCmdResolver;
import com.wb.workflow.core.config.WorkFlowCmdEnum;
import org.flowable.task.api.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: AbstractWorkFlowTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the abstract work flow task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public abstract class AbstractWorkFlowTaskCmd implements WorkFlowCmd {

    //  the work flow executor
    private WorkFlowCmdResolver cmdResolver = null;

    /**
     * add task operation with the specified request
     *
     * @param request the request
     */
    public void addTaskOperation(WorkFlowGenericCmdRequest request) {
        getCmdResolver();
        WorkFlowAddTaskOperationCmdRequest taskOperation = new WorkFlowAddTaskOperationCmdRequest();
        BeanUtils.copyProperties(request, taskOperation);
        taskOperation.setInstanceId(request.getInstanceId());
        taskOperation.setTaskId(request.getTaskId());
        taskOperation.setApproveOpinion(request.getApproveOpinion());
        // operation.setApproveResult(approveResult);
        taskOperation.setApproveType(WorkFlowCmdEnum.getOperation(request.getCmdType()));
        Task task = request.getTask();
        taskOperation.setTaskName(task.getName());
        taskOperation.setTaskKey(task.getTaskDefinitionKey());
        //  TODO 计算时间之差
        //  recordRequest.setTotalTime();
        cmdResolver.resolverCmdInvoke(WorkFlowCmdEnum.ADD_TASK_OPERATION.getType(), taskOperation);
    }

    /**
     * get cmd resolver
     */
    private void getCmdResolver() {
        if (ObjectUtils.isEmpty(cmdResolver)) {
            cmdResolver = SpringApplicationContextProvider.getBean(WorkFlowCmdResolver.class);
        }
    }
}
