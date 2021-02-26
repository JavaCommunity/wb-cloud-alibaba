package com.wb.workflow.core.repository;

import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: WorkFlowInstanceMapper
 * @Package: com.wb.workflow.core.repository
 * @Description: the work flow instance mapper
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public interface WorkFlowInstanceMapper {

    /**
     * save work flow instance entity
     *
     * @param instance the work flow instance entity
     * @return the save number
     */
    int save(WorkFlowInstanceEntity instance);

    /**
     * update work flow instance entity
     *
     * @param instance the work flow instance entity
     * @return the update number
     */
    int update(WorkFlowInstanceEntity instance);

    /**
     * query work flow instance entity with the specified instance id
     *
     * @param instanceId the instance id
     * @return the work flow instance entity
     */
    WorkFlowInstanceEntity queryForId(@Param(value = "instanceId") String instanceId);
}
