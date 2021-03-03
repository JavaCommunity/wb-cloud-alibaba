package com.wb.workflow.core.cmd.task;

import com.wb.common.utils.date.DateUtils;
import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.common.wrapper.SysUserWrapper;
import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowAddTaskOperationCmdRequest;
import com.wb.workflow.core.cmd.resolver.WorkFlowCmdResolver;
import com.wb.workflow.core.config.WorkFlowCmdEnum;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.exception.WorkFlowObjectNotFoundException;
import org.flowable.task.api.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: AbstractWorkFlowTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the abstract work flow task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public abstract class AbstractWorkFlowTaskCmd implements WorkFlowCmd {

    //  the exclude cmd list
    private static final List<String> excludeCmdList = Arrays.asList(new String[]{
            WorkFlowCmdEnum.GET_ALREADY_HANDLE_TASK.getType(),
            WorkFlowCmdEnum.GET_WAIT_HANDLE_TASK.getType()
    });

    //  the work flow executor
    private WorkFlowCmdResolver cmdResolver = null;

    /**
     * check task with the specified cmd request
     *
     * @param cmdRequest this cmd request
     */
    @Override
    public void check(WorkFlowGenericCmdRequest cmdRequest) {
        if (excludeCmdList.contains(cmdRequest.getCmdType())) {
            return;
        }

        //  the check task is exist
        Task task = cmdRequest.getTask();
        if (ObjectUtils.isEmpty(task)) {
            throw new WorkFlowObjectNotFoundException(WorkFlowErrorEnum.NOT_FOUND_TASK.getMsg(), AbstractWorkFlowTaskCmd.class);
        }

        //  TODO the check task authority
    }

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
        taskOperation.setApproveOpinion(request.getApproveOpinion());
        taskOperation.setApproveType(WorkFlowCmdEnum.getOperation(request.getCmdType()));
        Task task = request.getTask();
        taskOperation.setTaskName(task.getName());
        taskOperation.setTaskKey(task.getTaskDefinitionKey());
        taskOperation.setDueDate(DateUtils.formatDateTime(task.getDueDate()));
        SysUserWrapper userWrapper = WorkFlowContextHolder.getCurrentUser();
        if (!ObjectUtils.isEmpty(userWrapper)) {
            taskOperation.setApproverId(userWrapper.getId());
            taskOperation.setApproverName(userWrapper.getName());
        }
        taskOperation.setTaskId(null);
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
