package com.wb.workflow.service.service;

import com.wb.workflow.service.entity.WorkFlowGroupEntity;

/**
 * @ClassName: WorkFlowGroupService
 * @Package: com.wb.workflow.service.service
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
}
