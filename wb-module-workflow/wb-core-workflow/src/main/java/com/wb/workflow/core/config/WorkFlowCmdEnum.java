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

    //  process instance
    SAVE_DRAFT_INSTANCE("saveDraftInstance", "workFlowSaveDraftInstanceCmd", "保存流程实例草稿"),
    ACTIVATE_INSTANCE("activateInstance", "workFlowActivateInstanceCmd", "激活实例命令"),
    DELETE_INSTANCE("deleteInstance", "workFlowDeleteInstanceCmd", "删除流程实例"),
    START_INSTANCE("startInstance", "workFlowStartInstanceCmd", "启动流程实例"),
    DRAFT_START_INSTANCE("draftStartInstance", "workFlowDraftStartInstanceCmd", "启动草稿流程实例"),
    SUSPEND_INSTANCE("suspendInstance", "workFlowSuspendInstanceCmd", "挂起流程实例"),
    TERMINATION_INSTANCE("terminationInstance", "workFlowTerminateInstanceCmd", "终止流程"),

    //  task
    ADD_TASK_RECORD("addTaskRecord", "workFlowAddTaskRecordCmd", "添加任务操作记录"),
    AGENT_TASK("agentTask", "workFlowAgentTaskCmd", "办理任务"),
    CLAIM_TASK("claimTask", "workFlowClaimTaskCmd", "认领任务"),
    UN_CLAIM_TASK("unClaimTask", "workFlowUnClaimTaskCmd", "取消任务认领"),
    DELEGATE_TASK("delegateTask", "workFlowDelegateTaskCmd", "委派任务"),
    NORMAL_TASK_COMPLETE("normalTaskComplete", "workFlowNormalTaskCompleteCmd", "任务办理"),
    TURN_TASK("turnTask", "workFlowTurnTaskCmd", "转交任务"),
    TERMINATION_TASK("terminationTask", "workFlowTerminationTaskCmd", "终止任务"),
    GET_WAIT_HANDLE_TASK("getWaitHandleTask", "workFlowGetWaitHandleTaskCmd", "查询代办任务"),
    LOCK_TASK("lockTask", "workFlowLockTaskCmd", "锁定任务"),
    UN_LOCK_TASK("unLockTask", "workFlowUnLockTaskCmd", "解锁任务");

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
