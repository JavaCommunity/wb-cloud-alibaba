package com.wb.workflow.service.service.impl;

import com.wb.workflow.service.service.WorkFlowInstanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: WorkFlowInstanceServiceImpl
 * @Package: com.wb.workflow.service.service.impl
 * @Description: the work flow instance service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkFlowInstanceServiceImpl implements WorkFlowInstanceService {
}
