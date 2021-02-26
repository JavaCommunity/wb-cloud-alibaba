package com.wb.workflow.core.service;

import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import com.wb.workflow.core.vo.WorkFlowInstanceVo;

/**
 * @ClassName: WorkFlowInstanceService
 * @Package: com.wb.workflow.core.service
 * @Description: the work flow instance service
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface WorkFlowInstanceService {

    /**
     * save work flow instance entity
     *
     * @param instance the work flow instance entity
     */
    void save(WorkFlowInstanceEntity instance);

    /**
     * 执行流程实例相关命令
     *
     * @param instanceVo 流程实例vo
     * @return 执行流程实例命令返回
     */
    Object executeCmd(WorkFlowInstanceVo instanceVo);
}
