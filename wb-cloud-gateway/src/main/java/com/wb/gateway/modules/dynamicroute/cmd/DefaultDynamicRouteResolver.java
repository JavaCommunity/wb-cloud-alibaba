package com.wb.gateway.modules.dynamicroute.cmd;

import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.gateway.modules.dynamicroute.config.DynamicRouteActionEnum;
import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: DefaultDynamicRouteResolver
 * @Package: com.wb.gateway.modules.dynamicroute.cmd
 * @Description: the default dynamic route resolver
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Component
public class DefaultDynamicRouteResolver implements DynamicRouteResolver {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DefaultDynamicRouteResolver.class);

    @Override
    public boolean isSupport(String action) {
        return DynamicRouteActionEnum.isSupport(action);
    }

    @Override
    public Object resolverCmdInvoke(DynamicRouteVo routeVo, String action) {
        Assert.hasText(action, "'action' must not be null！");
        String beanId = DynamicRouteActionEnum.getBeanId(action);
        Assert.hasText(beanId, "not found action！");

        Object bean = SpringApplicationContextProvider.getBean(beanId);
        if (ObjectUtils.isEmpty(bean) || !(bean instanceof DynamicRouteCommand)) {
            log.error("not found dynamic route command,action:{}", action);
            throw new IllegalArgumentException("not found dynamic route command！");
        }

        DynamicRouteCommand command = (DynamicRouteCommand) bean;
        return command.execute(routeVo);
    }
}
