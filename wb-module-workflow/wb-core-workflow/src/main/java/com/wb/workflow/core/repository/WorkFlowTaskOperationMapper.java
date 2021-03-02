package com.wb.workflow.core.repository;

import com.wb.workflow.core.entity.WorkFlowTaskOperationEntity;

/**
 * @ClassName: WorkFlowTaskOperationMapper
 * @Package: com.wb.workflow.core.repository
 * @Description: the work flow task operation mapper
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
public interface WorkFlowTaskOperationMapper {

    /**
     * save work flow task operation entity
     *
     * @param taskOperation the task operation
     * @return the save number
     */
    int save(WorkFlowTaskOperationEntity taskOperation);

    /**
     * update work flow task operation entity
     *
     * @param taskOperation the task operation
     * @return the update number
     */
    int update(WorkFlowTaskOperationEntity taskOperation);
}
