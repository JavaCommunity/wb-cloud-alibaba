package com.wb.flowable.ext.api.event;

import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEventType;
import org.flowable.engine.delegate.event.AbstractFlowableEngineEventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Map;

/**
 * @ClassName: FlowableDispatcherEventListenerExt
 * @Package: com.wb.flowable.ext.api.event
 * @Description: the flowable dispatcher event listener ext
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
@Component
public class FlowableDispatcherEventListenerExt extends AbstractFlowableEngineEventListener implements FlowableEventListener {

    //  the event listener ext map
    private Map<String, FlowableEventListenerExt> eventListenerMap = null;

    /**
     * constructs a new flowableDispatcherEventListenerExt
     */
    public FlowableDispatcherEventListenerExt() {
    }

    /**
     * constructs a new flowableDispatcherEventListenerExt
     * with the specified event listener map
     *
     * @param eventListenerMap the event listener map
     */
    public FlowableDispatcherEventListenerExt(Map<String, FlowableEventListenerExt> eventListenerMap) {
        this.eventListenerMap = eventListenerMap;
    }

    @Override
    public void onEvent(FlowableEvent flowableEvent) {
        FlowableEventType eventType = flowableEvent.getType();
        if (!eventListenerMap.containsKey(eventType)) {
            return;
        }

        FlowableEventListenerExt eventListener = eventListenerMap.get(eventType);
        if (ObjectUtils.isEmpty(eventListener)) {
            return;
        }

        eventListener.onEvent(flowableEvent);
    }
}
