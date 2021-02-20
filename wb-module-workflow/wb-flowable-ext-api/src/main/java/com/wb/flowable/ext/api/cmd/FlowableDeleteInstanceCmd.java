package com.wb.flowable.ext.api.cmd;

import org.flowable.common.engine.api.FlowableIllegalArgumentException;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.util.CommandContextUtil;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: FlowableDeleteInstanceCmd
 * @Package: com.wb.flowable.ext.api.cmd
 * @Description: the flowable delete instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/20
 * @Version: 1.0
 */
public class FlowableDeleteInstanceCmd implements Command<Void> {

    //  the flowable runtime service
    private RuntimeService runtimeService;

    //  the process instance id
    private String processInstanceId;

    //  the delete reason
    private String deleteReason;

    //  the cascade
    private boolean cascade;

    /**
     * constructs a new flowableDeleteInstanceCmd with the specified
     * runtime service and process instance id and delete reason and cascade.
     *
     * @param runtimeService    the runtime service
     * @param processInstanceId the process instance id
     * @param deleteReason      the delete reason
     * @param cascade           the cascade
     */
    public FlowableDeleteInstanceCmd(RuntimeService runtimeService, String processInstanceId,
                                     String deleteReason, boolean cascade) {
        this.runtimeService = runtimeService;
        this.processInstanceId = processInstanceId;
        this.deleteReason = deleteReason;
        this.cascade = cascade;
    }

    @Override
    public Void execute(CommandContext commandContext) {
        if (!cascade) {
            runtimeService.deleteProcessInstance(processInstanceId, deleteReason);
        }

        //  cascade delete process instance info
        ExecutionEntity processInstanceEntity = CommandContextUtil
                .getExecutionEntityManager(commandContext)
                .findById(processInstanceId);
        //  check process instance
        if (ObjectUtils.isEmpty(processInstanceEntity)) {
            throw new FlowableObjectNotFoundException("No process instance found for id '" + processInstanceId + "'", FlowableDeleteInstanceCmd.class);
        }
        if (processInstanceEntity.isDeleted()) {
            throw new FlowableIllegalArgumentException("process instance is deleted！");
        }

        //  delete process instance
        CommandContextUtil
                .getExecutionEntityManager(commandContext)
                .deleteProcessInstance(processInstanceEntity.getProcessInstanceId(), deleteReason, cascade);
        return null;
    }
}
