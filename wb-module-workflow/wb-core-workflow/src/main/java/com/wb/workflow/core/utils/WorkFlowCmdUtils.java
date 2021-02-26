package com.wb.workflow.core.utils;

import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.executor.WorkFlowExecutor;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.resolver.DefaultWorkFlowCmdResolver;
import com.wb.workflow.core.config.WorkFlowCmdEnum;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.exception.WorkFlowObjectNotFoundException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @ClassName: WorkFlowCmdUtils
 * @Package: com.wb.workflow.core.utils
 * @Description: the work flow cmd utils
 * @Author：[bo.wang]
 * @Date: 2021/2/26
 * @Version: 1.0
 */
public class WorkFlowCmdUtils {

    /**
     * get optional cmd with
     *
     * @param cmdType
     * @return
     */
    public static WorkFlowCmd getOptionalCmd(WorkFlowCmdEnum cmdType) {
        if (ObjectUtils.isEmpty(cmdType)) {
            return null;
        }
        String beanId = cmdType.getBeanId();
        if (!StringUtils.hasText(beanId)) {
            throw new WorkFlowObjectNotFoundException(WorkFlowErrorEnum.NOT_FOUND_CMD.getMsg(), WorkFlowCmdUtils.class);
        }
        Object bean = SpringApplicationContextProvider.getBean(beanId);
        if (ObjectUtils.isEmpty(bean) || !(bean instanceof WorkFlowCmd)) {
            throw new WorkFlowObjectNotFoundException(WorkFlowErrorEnum.NOT_FOUND_CMD.getMsg(), WorkFlowCmdUtils.class);
        }
        WorkFlowCmd command = (WorkFlowCmd) bean;
        return command;
    }

    /**
     * get request object with the specified command
     *
     * @param command the command
     * @return the workFlowGenericCmdRequest
     */
    public static WorkFlowGenericCmdRequest getReqObj(WorkFlowCmd command) {
        if (ObjectUtils.isEmpty(command)) {
            return null;
        }
        try {
            return (WorkFlowGenericCmdRequest) command.getReqClass().newInstance();
        } catch (Exception e) {
            throw new WorkFlowObjectNotFoundException(WorkFlowErrorEnum.EXECUTE_CMD.getMsg(), DefaultWorkFlowCmdResolver.class);
        }
    }
}
