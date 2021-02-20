package com.wb.flowable.ext.api.instance;

import com.wb.flowable.ext.api.cmd.FlowableDeleteInstanceCmd;
import com.wb.flowable.ext.api.config.FlowableErrorEnum;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.engine.ManagementService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: DefaultFlowableInstanceExt
 * @Package: com.wb.flowable.ext.api.instance
 * @Description: the default flowable instance ext
 * @Author：[bo.wang]
 * @Date: 2021/2/20
 * @Version: 1.0
 */
@Component
public class DefaultFlowableInstanceExt implements FlowableInstanceExt {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ManagementService managementService;

    @Override
    public void checkForId(String processInstanceId) {
        ProcessInstance processInstance = this.queryForId(processInstanceId);
        if (ObjectUtils.isEmpty(processInstance)) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_INSTANCE.getMsg()
                    , DefaultFlowableInstanceExt.class);
        }
    }

    @Override
    public ProcessInstance queryForId(String processInstanceId) {
        Assert.hasLength(processInstanceId, "'processInstanceId' must not be null！");

        ProcessInstance processInstance = runtimeService
                .createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();
        return processInstance;
    }

    @Override
    public void delete(String processInstanceId, String deleteReason, boolean cascade) {
        Assert.hasLength(processInstanceId, "'processInstanceId' must not be null！");

        managementService.executeCommand(new FlowableDeleteInstanceCmd(runtimeService, processInstanceId, deleteReason, cascade));
    }
}
