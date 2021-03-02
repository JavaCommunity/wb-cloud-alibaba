package com.wb.workflow.core.service;

import com.wb.workflow.core.entity.WorkFlowTaskOperationEntity;

/**
 * @ClassName: WorkFlowTaskOperationService
 * @Package: com.wb.workflow.core.service
 * @Description: the work flow task operation service
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
public interface WorkFlowTaskOperationService {

    /**
     * save work flow task operation entity
     *
     * @param taskOperationEntity the task operation entity
     */
    void save(WorkFlowTaskOperationEntity taskOperationEntity);
}
