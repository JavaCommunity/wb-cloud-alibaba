package com.wb.workflow.core.repository;

import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: WorkFlowDefinitionMapper
 * @Package: com.wb.workflow.core.repository
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

    /**
     * query definition entity with the specified definition code
     *
     * @param code the definition code
     * @return the definition entity
     */
    List<WorkFlowDefinitionEntity> queryForCode(@Param(value = "code") String code);
}
