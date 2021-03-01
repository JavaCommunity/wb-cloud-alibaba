package com.wb.workflow.core.cmd.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowGetWaitHandleTaskCmdRequest;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.vo.WorkFlowWaitHandleTaskVo;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: WorkFlowGetWaitHandleTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow get wait handle task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowGetWaitHandleTaskCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private TaskService taskService;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowGetWaitHandleTaskCmdRequest request = (WorkFlowGetWaitHandleTaskCmdRequest) cmdRequest;
        String userId = request.getUserId();
        if (StringUtils.isEmpty(userId)) {
            userId = WorkFlowContextHolder.getCurrentUserId();
        }

        TaskQuery taskQuery = taskService.createTaskQuery();
        List<Task> tasks = taskQuery
                .or()
                .taskCandidateOrAssigned(userId)
                .taskOwner(userId)
                .endOr()
                .list();
        if (CollectionUtils.isEmpty(tasks)) {
            return null;
        }
        List<WorkFlowWaitHandleTaskVo> taskList = new ArrayList<>();
        tasks.stream().forEach((task -> {
            taskList.add(new WorkFlowWaitHandleTaskVo(
                    task.getId(),
                    task.getName(),
                    task.getCreateTime()
            ));
        }));
        return (T) taskList;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowGetWaitHandleTaskCmdRequest.class;
    }
}
