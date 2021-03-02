package com.wb.workflow.core.event.instance;

import com.wb.workflow.core.event.WorkFlowEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.engine.delegate.event.impl.FlowableEntityEventImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: WorkFlowInstanceEndEventListener
 * @Package: com.wb.workflow.core.event.instance
 * @Description: the work flow instance end event listener
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class WorkFlowInstanceEndEventListener implements WorkFlowEventListener<FlowableEntityEventImpl> {

    @Override
    public String getType() {
        return FlowableEngineEventType.PROCESS_COMPLETED.name();
    }

    @Override
    public void onEvent(FlowableEntityEventImpl entityEvent) {
        //
    }
}
