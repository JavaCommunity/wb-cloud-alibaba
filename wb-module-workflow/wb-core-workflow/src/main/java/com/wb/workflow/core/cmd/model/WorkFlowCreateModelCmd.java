package com.wb.workflow.core.cmd.model;

import com.wb.flowable.ext.api.model.FlowableModelExt;
import com.wb.flowable.ext.api.model.FlowableModelRequest;
import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.model.WorkFlowCreateModelCmdRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowCreateModelCmd
 * @Package: com.wb.workflow.core.cmd.model
 * @Description: the work flow create model cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowCreateModelCmd implements WorkFlowCmd {

    @Autowired
    private FlowableModelExt flowableModelExt;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        //  create flowable model
        WorkFlowCreateModelCmdRequest request = (WorkFlowCreateModelCmdRequest) cmdRequest;
        FlowableModelRequest modelRequest = new FlowableModelRequest();
        BeanUtils.copyProperties(request, modelRequest);
        String fModelId = flowableModelExt.create(modelRequest);
        return (T) fModelId;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowCreateModelCmdRequest.class;
    }
}
