package com.wb.workflow.service.service;

import com.wb.workflow.service.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.service.vo.WorkFlowDefinitionVo;

import java.util.List;

/**
 * @ClassName: WorkFlowDefinitionService
 * @Package: com.wb.workflow.service.service
 * @Description: the work flow definition service
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface WorkFlowDefinitionService {

    /**
     * 保存流程定义信息
     *
     * @param definitionVo 流程定义信息
     * @return 流程定义实体
     */
    WorkFlowDefinitionEntity save(WorkFlowDefinitionVo definitionVo);

    /**
     * 修改流程定义信息
     *
     * @param definitionVo 流程定义信息
     * @return 流程定义实体
     */
    WorkFlowDefinitionEntity update(WorkFlowDefinitionVo definitionVo);

    /**
     * 根据流程定义ID查询流程定义信息
     *
     * @param definitionId 流程定义ID
     * @return 流程定义实体
     */
    WorkFlowDefinitionEntity queryForId(String definitionId);

    /**
     * 根据流程定义Code查询流程定义信息
     *
     * @param definitionCode 流程定义CODE
     * @return 流程定义信息
     */
    List<WorkFlowDefinitionEntity> queryForCode(String definitionCode);
}
