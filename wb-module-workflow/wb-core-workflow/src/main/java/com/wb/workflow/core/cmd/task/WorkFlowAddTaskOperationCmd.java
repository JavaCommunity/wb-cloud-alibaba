package com.wb.workflow.core.cmd.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowAddTaskOperationCmdRequest;
import com.wb.workflow.core.entity.WorkFlowTaskOperationEntity;
import com.wb.workflow.core.service.WorkFlowTaskOperationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: WorkFlowAddTaskOperationCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow add task operation cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class WorkFlowAddTaskOperationCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private WorkFlowTaskOperationService taskOperationService;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowAddTaskOperationCmdRequest request = (WorkFlowAddTaskOperationCmdRequest) cmdRequest;
        WorkFlowTaskOperationEntity taskOperationEntity = new WorkFlowTaskOperationEntity();
        BeanUtils.copyProperties(request, taskOperationEntity);
        taskOperationEntity.setTaskId(cmdRequest.getTask().getId());
        taskOperationService.save(taskOperationEntity);
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowAddTaskOperationCmdRequest.class;
    }
}
