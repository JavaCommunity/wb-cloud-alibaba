package com.wb.workflow.core.cmd.group;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.group.WorkFlowCreateGroupCmdRequest;
import com.wb.workflow.core.entity.WorkFlowGroupEntity;
import com.wb.workflow.core.service.WorkFlowGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowCreateGroupCmd
 * @Package: com.wb.workflow.core.cmd.group
 * @Description: the work flow create group cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/20
 * @Version: 1.0
 */
@Component
public class WorkFlowCreateGroupCmd implements WorkFlowCmd {

    @Autowired
    private WorkFlowGroupService groupService;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowCreateGroupCmdRequest request = (WorkFlowCreateGroupCmdRequest) cmdRequest;
        groupService.checkForName(request.getName());

        WorkFlowGroupEntity groupEntity = new WorkFlowGroupEntity();
        BeanUtils.copyProperties(request, groupEntity);
        groupService.save(groupEntity);
        return (T) groupEntity.getId();
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowCreateGroupCmdRequest.class;
    }
}
