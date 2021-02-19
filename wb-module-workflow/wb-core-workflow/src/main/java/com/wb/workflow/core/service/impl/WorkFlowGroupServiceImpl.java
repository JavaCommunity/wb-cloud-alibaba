package com.wb.workflow.core.service.impl;

import com.wb.workflow.core.entity.WorkFlowGroupEntity;
import com.wb.workflow.core.service.WorkFlowGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: WorkFlowGroupServiceImpl
 * @Package: com.wb.workflow.core.service.impl
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
