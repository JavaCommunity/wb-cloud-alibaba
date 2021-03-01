package com.wb.flowable.ext.api.instance;

import com.wb.flowable.ext.api.cmd.FlowableDeleteInstanceCmd;
import com.wb.flowable.ext.api.config.FlowableErrorEnum;
import com.wb.flowable.ext.api.utils.FlowableReqCheckUtils;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.engine.ManagementService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public ProcessInstance start(FlowableInstanceStartRequest request) {
        FlowableReqCheckUtils.checkEmpty(request, "request");
        String definitionId = request.getDefinitionId();
        FlowableReqCheckUtils.checkEmpty(definitionId, "definitionId");
        String businessKey = request.getBusinessKey();
        FlowableReqCheckUtils.checkEmpty(businessKey, "businessKey");

        try {
            String userId = request.getUserId();
            if (!ObjectUtils.isEmpty(userId)) {
                Authentication.setAuthenticatedUserId(userId);
            }
            Map<String, Object> variables = request.getVariables();
            if (CollectionUtils.isEmpty(variables)) {
                return runtimeService.startProcessInstanceById(definitionId, businessKey);
            } else {
                return runtimeService.startProcessInstanceById(definitionId, businessKey, variables);
            }
        } catch (Exception e) {
            throw new FlowableException(FlowableErrorEnum.START_INSTANCE.getMsg());
        } finally {
            Authentication.setAuthenticatedUserId(null);
        }
    }

    @Override
    public List<String> queryExecutionInstanceIdList(String id) {
        FlowableReqCheckUtils.checkEmpty(id, "id");

        List<Execution> executionInstanceList = this.getExecutionInstance(id);
        if (ObjectUtils.isEmpty(executionInstanceList)) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_EXECUTION_INSTANCE.getMsg());
        }
        List<String> executionInstanceId = executionInstanceList
                .stream()
                .map(Execution::getId)
                .collect(Collectors.toList());
        return executionInstanceId;
    }

    @Override
    public List<Execution> getExecutionInstance(String id) {
        FlowableReqCheckUtils.checkEmpty(id, "id");

        return runtimeService
                .createExecutionQuery()
                .parentId(id)
                .list();
    }

    @Override
    public void jumpToActivityNode(List<String> executionInstanceIdList, String activityId) {
        FlowableReqCheckUtils.checkEmpty(executionInstanceIdList, "executionInstanceIdList");
        FlowableReqCheckUtils.checkEmpty(activityId, "activityId");

        runtimeService.createChangeActivityStateBuilder()
                .moveExecutionsToSingleActivityId(executionInstanceIdList, activityId)
                .changeState();
    }

    @Override
    public void active(String processInstanceId) {
        FlowableReqCheckUtils.checkEmpty(processInstanceId, "processInstanceId");

        runtimeService.activateProcessInstanceById(processInstanceId);
    }

    @Override
    public void suspend(String processInstanceId) {
        FlowableReqCheckUtils.checkEmpty(processInstanceId, "processInstanceId");

        runtimeService.suspendProcessInstanceById(processInstanceId);
    }
}
