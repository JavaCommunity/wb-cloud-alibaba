package com.wb.gateway.modules.dynamicroute.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @ClassName: DynamicRouteGenericCmd
 * @Package: com.wb.gateway.modules.dynamicroute.cmd
 * @Description: the dynamic route generic cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public abstract class DynamicRouteGenericCmd<T> implements DynamicRouteCommand<T> {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DynamicRouteGenericCmd.class);

    /**
     * refresh route with the specified event publisher
     *
     * @param eventPublisher the event publisher
     */
    public void refresh(ApplicationEventPublisher eventPublisher) {
        eventPublisher.publishEvent(new RefreshRoutesEvent(this));
    }
}
