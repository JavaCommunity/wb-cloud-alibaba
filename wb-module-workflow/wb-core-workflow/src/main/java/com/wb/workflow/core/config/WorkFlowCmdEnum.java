package com.wb.workflow.core.config;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName: WorkFlowCmdTypeEnum
 * @Package: com.wb.workflow.core.config
 * @Description: the work flow cmd enum
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public enum WorkFlowCmdEnum {

    //  group
    CREATE_GROUP("createGroup", "workFlowCreateGroupCmd", "创建分组"),

    //  model
    CREATE_MODEL("createModel", "workFlowCreateModelCmd", "创建模型"),

    //  definition
    CREATE_DEFINITION("createDefinition", "workFlowCreateDefinitionCmd", "创建流程定义信息"),
    DEPLOY_DEFINITION("deployDefinition", "workFlowDeployDefinitionCmd", "部署流程"),

    //  process instance
    ACTIVATE_INSTANCE("activateInstance", "workFlowActivateInstanceCmd", "激活实例命令"),
    DELETE_INSTANCE("deleteInstance", "workFlowDeleteInstanceCmd", "删除流程实例"),
    START_INSTANCE("startInstance", "workFlowStartInstanceCmd", "启动流程实例"),
    SUSPEND_INSTANCE("suspendInstance", "workFlowSuspendInstanceCmd", "挂起流程实例"),
    TERMINATION_INSTANCE("terminationInstance", "workFlowTerminateInstanceCmd", "终止流程"),

    //  task
    ADD_TASK_RECORD("addTaskRecord", "workFlowAddTaskRecordCmd", "添加任务操作记录"),
    CLAIM_TASK("claimTask", "workFlowClaimTaskCmd", "认领任务"),
    UN_CLAIM_TASK("unClaimTask", "workFlowUnClaimTaskCmd", "取消任务认领"),
    DELEGATE_TASK("delegateTask", "workFlowDelegateTaskCmd", "委派任务"),
    COMPLETE_TASK("completeTask", "workFlowCompleteTaskCmd", "办理任务"),
    TURN_TASK("turnTask", "workFlowTurnTaskCmd", "转交任务"),
    TERMINATION_TASK("terminationTask", "workFlowTerminationTaskCmd", "终止任务"),
    GET_WAIT_HANDLE_TASK("getWaitHandleTask", "workFlowGetWaitHandleTaskCmd", "查询代办任务"),
    GET_ALREADY_HANDLE_TASK("getAlreadyHandleTask", "workFlowGetAlreadyHandleTaskCmd", "查询已办任务");

    //  the type
    private String type;

    //  the bean id
    private String beanId;

    //  the description
    private String description;

    /**
     * constructs a new workFlowCmdEnum with the specified type
     * and bean id and description.
     *
     * @param type        the type
     * @param beanId      the bean id
     * @param description the description
     */
    WorkFlowCmdEnum(String type, String beanId, String description) {
        this.type = type;
        this.beanId = beanId;
        this.description = description;
    }

    /**
     * check is support cmd with specified cmd type.
     *
     * @param cmdType the cmd type
     * @return <tt>tue<tt/> if support
     */
    public static boolean isSupport(String cmdType) {
        return StringUtils.isEmpty(cmdType) ? false : Arrays.asList(WorkFlowCmdEnum.values())
                .stream().filter(type -> type.type.equalsIgnoreCase(cmdType)).findAny().isPresent();
    }

    /**
     * get bean id with the specified cmd type.
     *
     * @param cmdType the cmd type
     * @return the bean id
     */
    public static String getBeanId(String cmdType) {
        Optional<WorkFlowCmdEnum> cmdEnumOptional = Arrays.asList(WorkFlowCmdEnum.values())
                .stream().filter(type -> type.type.equalsIgnoreCase(cmdType)).findFirst();
        return cmdEnumOptional.isPresent() ? cmdEnumOptional.get().beanId : null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
