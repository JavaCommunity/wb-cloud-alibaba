package com.wb.workflow.core.service.impl;

import com.wb.common.utils.entity.EntityUtils;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.entity.WorkFlowTaskOperationEntity;
import com.wb.workflow.core.exception.WorkFlowServiceException;
import com.wb.workflow.core.repository.WorkFlowTaskOperationMapper;
import com.wb.workflow.core.service.WorkFlowTaskOperationService;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: WorkFlowTaskOperationServiceImpl
 * @Package: com.wb.workflow.core.service.impl
 * @Description: the work flow task operation service impl
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkFlowTaskOperationServiceImpl implements WorkFlowTaskOperationService {

    @Autowired
    private WorkFlowTaskOperationMapper taskOperationMapper;

    @Override
    public void save(WorkFlowTaskOperationEntity taskOperationEntity) {
        WorkFlowReqCheckUtils.checkEmpty(taskOperationEntity, "taskOperationEntity");

        EntityUtils.save(taskOperationEntity, WorkFlowContextHolder.getCurrentUser());
        int saveNum = taskOperationMapper.save(taskOperationEntity);
        if (saveNum < 1) {
            throw new WorkFlowServiceException("save work flow task operation entity error！");
        }
    }
}
