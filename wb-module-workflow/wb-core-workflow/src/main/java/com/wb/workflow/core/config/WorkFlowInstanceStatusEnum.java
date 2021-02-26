package com.wb.workflow.core.config;

/**
 * @ClassName: WorkFlowInstanceStatusEnum
 * @Package: com.wb.workflow.core.config
 * @Description: the work flow instance status enum
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public enum WorkFlowInstanceStatusEnum {

    DRAFT,
    START,
    FINISH,
    TERMINATE,
    SUSPEND,
    ACTIVATE,
    RUNTIME;
}
