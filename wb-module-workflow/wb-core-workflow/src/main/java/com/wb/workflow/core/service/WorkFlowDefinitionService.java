package com.wb.workflow.core.service;

import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.vo.WorkFlowDefinitionVo;

import java.util.List;

/**
 * @ClassName: WorkFlowDefinitionService
 * @Package: com.wb.workflow.core.service
 * @Description: the work flow definition service
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface WorkFlowDefinitionService {

    /**
     * 保存流程定义信息
     *
     * @param definitionEntity 流程定义信息
     */
    void save(WorkFlowDefinitionEntity definitionEntity);

    /**
     * 修改流程定义模型信息
     *
     * @param definitionVo 流程定义信息
     * @return 流程定义实体
     */
    WorkFlowDefinitionEntity updateModel(WorkFlowDefinitionVo definitionVo);

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

    /**
     * 执行流程定义相关命令
     *
     * @param definitionVo 流程定义信息vo
     * @return 返回执行流程定义命令结果
     */
    Object executeCmd(WorkFlowDefinitionVo definitionVo);

    /**
     * 检查流程定义code是否存在
     *
     * @param definitionCode 流程定义code
     */
    void checkForCode(String definitionCode);

    /**
     * 根据流程定义ID判断流程定义信息是否存在
     *
     * @param definitionId 流程定义ID
     */
    void checkForId(String definitionId);

    /**
     * 修改流程定义信息
     *
     * @param definition
     */
    void update(WorkFlowDefinitionEntity definition);

    /**
     * 根据流程定义CODE查询主流程定义信息
     *
     * @param definitionCode 流程定义code
     * @return
     */
    WorkFlowDefinitionEntity queryMainForCode(String definitionCode);
}
