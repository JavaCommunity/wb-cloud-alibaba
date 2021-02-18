package com.wb.workflow.service.repository;

import com.wb.workflow.service.entity.WorkFlowDefinitionEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: WorkFlowDefinitionMapper
 * @Package: com.wb.workflow.service.repository
 * @Description: the work flow definition mapper
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface WorkFlowDefinitionMapper {

    /**
     * save definition entity with the specified definition entity
     *
     * @param definitionEntity the definition entity
     * @return the save number
     */
    int save(WorkFlowDefinitionEntity definitionEntity);

    /**
     * update definition entity with the specified definition entity
     *
     * @param definitionEntity the definition entity
     * @return the update number
     */
    int update(WorkFlowDefinitionEntity definitionEntity);

    /**
     * query definition entity with the specified definition id
     *
     * @param definitionId the definition id
     * @return the definition entity
     */
    WorkFlowDefinitionEntity queryForId(@Param(value = "definitionId") String definitionId);
}
