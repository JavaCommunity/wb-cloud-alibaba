package com.wb.sms.component.command.resolver;

import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.sms.component.command.SmsCommand;
import com.wb.sms.component.command.executor.SmsCmdExecutor;
import com.wb.sms.component.command.request.SmsCmdRequest;
import com.wb.sms.component.config.SmsCmdEnum;
import com.wb.sms.component.config.SmsErrorEnum;
import com.wb.sms.component.exception.SmsServerException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @ClassName: DefaultSmsCmdResolver
 * @Package: com.wb.sms.component.command.resolver
 * @Description: the default sms cmd resolver
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
@Component
public class DefaultSmsCmdResolver implements SmsCmdResolver {

    @Autowired
    private SmsCmdExecutor defaultExecutor;

    @Override
    public boolean support(String cmdType) {
        return SmsCmdEnum.isSupport(cmdType);
    }

    @Override
    public <T> T resolverCmdInvoke(String cmdType, SmsCmdRequest<T> request) {
        String beanId = SmsCmdEnum.getBeanId(cmdType);
        if (StringUtils.isEmpty(beanId)) {
            throw new SmsServerException(SmsErrorEnum.SYSTEM.getMsg());
        }
        Object bean = null;
        try {
            bean = SpringApplicationContextProvider.getBean(beanId);
        } catch (NoSuchBeanDefinitionException e) {
            throw new SmsServerException(e.getMessage());
        }
        if (ObjectUtils.isEmpty(bean) || !(bean instanceof SmsCommand)) {
            throw new SmsServerException(SmsErrorEnum.SYSTEM.getMsg());
        }
        SmsCommand command = (SmsCommand) bean;
        return defaultExecutor.execute(command, request);
    }
}
