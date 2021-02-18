package com.wb.workflow.service.service.impl;

import com.wb.workflow.service.entity.WorkFlowGroupEntity;
import com.wb.workflow.service.service.WorkFlowGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: WorkFlowGroupServiceImpl
 * @Package: com.wb.workflow.service.service.impl
 * @Description: the work flow group service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkFlowGroupServiceImpl implements WorkFlowGroupService {

    @Override
    public WorkFlowGroupEntity queryForId(String groupId) {
        return null;
    }
}
