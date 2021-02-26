package com.wb.workflow.core.service;

import com.wb.workflow.core.entity.WorkFlowGroupEntity;
import com.wb.workflow.core.vo.WorkFlowGroupVo;

/**
 * @ClassName: WorkFlowGroupService
 * @Package: com.wb.workflow.core.service
 * @Description: the work flow group service
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface WorkFlowGroupService {

    /**
     * 根据分组ID查询流程分组信息
     *
     * @param groupId 分组ID
     * @return 分组实体
     */
    WorkFlowGroupEntity queryForId(String groupId);

    /**
     * 根据分组名称查询流程分组信息
     *
     * @param groupName 分组名称
     * @return 分组实体信息
     */
    WorkFlowGroupEntity queryForName(String groupName);

    /**
     * 指定流程分组相关命令
     *
     * @param groupVo 流程分组信息vo
     * @return 返回执行流程分组命令结果
     */
    Object executeCmd(WorkFlowGroupVo groupVo);

    /**
     * 保存流程分组信息
     *
     * @param groupEntity 流程分组信息
     */
    void save(WorkFlowGroupEntity groupEntity);

    /**
     * 根据流程分组检查信息是否存在
     *
     * @param groupId 流程分组ID
     */
    void checkForId(String groupId);

    /**
     * 根据流分组名称检查是否信息是否存在
     *
     * @param groupName 流程分组名称
     */
    void checkForName(String groupName);
}
