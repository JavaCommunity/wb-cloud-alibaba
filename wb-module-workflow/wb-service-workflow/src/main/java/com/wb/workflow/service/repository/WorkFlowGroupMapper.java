package com.wb.workflow.service.repository;

import com.wb.workflow.service.entity.WorkFlowGroupEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: WorkFlowGroupMapper
 * @Package: com.wb.workflow.service.repository
 * @Description: the work flow group mapper
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface WorkFlowGroupMapper {

    /**
     * save definition entity with the specified group entity
     *
     * @param groupEntity the group entity
     * @return the save number
     */
    int save(WorkFlowGroupEntity groupEntity);

    /**
     * update definition entity with the specified group entity
     *
     * @param groupEntity the group entity
     * @return the update number
     */
    int update(WorkFlowGroupEntity groupEntity);

    /**
     * query definition entity with the specified group id
     *
     * @param groupId the group id
     * @return the group entity
     */
    WorkFlowGroupEntity queryForId(@Param(value = "definitionId") String groupId);
}
