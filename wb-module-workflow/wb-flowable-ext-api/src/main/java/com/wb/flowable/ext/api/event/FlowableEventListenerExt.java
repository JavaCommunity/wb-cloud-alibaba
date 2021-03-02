package com.wb.flowable.ext.api.event;

/**
 * @ClassName: FlowableEventListenerExt
 * @Package: com.wb.flowable.ext.api.event
 * @Description: the flowable event listener ext
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
public interface FlowableEventListenerExt<T> {

    /**
     * get event type
     *
     * @return the event type
     */
    String getType();

    /**
     * on event
     *
     * @param t
     */
    void onEvent(T t);
}
