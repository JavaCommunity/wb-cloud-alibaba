package com.wb.workflow.core.cmd.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowGetAlreadyHandleTaskCmdRequest;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.vo.WorkFlowAlreadyHandleTaskVo;
import org.flowable.engine.HistoryService;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: WorkFlowAlreadyHandleTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow get already handle task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowGetAlreadyHandleTaskCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private HistoryService historyService;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowGetAlreadyHandleTaskCmdRequest request = (WorkFlowGetAlreadyHandleTaskCmdRequest) cmdRequest;
        String userId = request.getUserId();
        if (StringUtils.isEmpty(userId)) {
            userId = WorkFlowContextHolder.getCurrentUserId();
        }
        List<HistoricTaskInstance> list = historyService
                .createHistoricTaskInstanceQuery()
                .finished()
                .or()
                .taskAssignee(userId)
                .taskOwner(userId)
                .endOr()
                .list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<WorkFlowAlreadyHandleTaskVo> hisTaskList = new ArrayList<>();
        list.stream().forEach((hisTask) -> {
            hisTaskList.add(new WorkFlowAlreadyHandleTaskVo(
                    hisTask.getId(),
                    hisTask.getName(),
                    hisTask.getCreateTime(),
                    hisTask.getEndTime(),
                    hisTask.getDueDate()
            ));
        });
        return (T) hisTaskList;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowGetAlreadyHandleTaskCmdRequest.class;
    }
}
