package com.wb.workflow.core.service;

import com.wb.workflow.core.vo.WorkFlowTaskVo;
import org.flowable.task.api.Task;

/**
 * @ClassName: WorkFlowTaskService
 * @Package: com.wb.workflow.core.service
 * @Description: the work flow task service
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public interface WorkFlowTaskService {

    /**
     * 执行流程任务相关命令
     *
     * @param taskVo 流程任务vo
     * @return 返回流程任务命令执行结果集
     */
    Object executeCmd(WorkFlowTaskVo taskVo);

    /**
     * 根据任务ID查询任务详细信息
     *
     * @param taskId 任务ID
     * @return
     */
    Task queryForId(String taskId);
}
