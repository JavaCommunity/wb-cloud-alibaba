package com.wb.flowable.ext.api.task;

import com.wb.flowable.ext.api.utils.FlowableReqCheckUtils;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DefaultFlowableTaskExt
 * @Package: com.wb.flowable.ext.api.task
 * @Description: the default flowable task ext
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class DefaultFlowableTaskExt implements FlowableTaskExt {

    @Autowired
    private TaskService taskService;

    @Override
    public Task queryForId(String taskId) {
        FlowableReqCheckUtils.checkEmpty(taskId, "taskId");

        return taskService
                .createTaskQuery()
                .taskId(taskId)
                .singleResult();
    }
}
