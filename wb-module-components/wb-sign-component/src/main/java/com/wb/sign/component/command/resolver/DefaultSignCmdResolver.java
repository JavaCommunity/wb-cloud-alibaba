package com.wb.sign.component.command.resolver;

import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.sign.component.command.SignCommand;
import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.result.SignResult;
import com.wb.sign.component.config.SignCmdEnum;
import com.wb.sign.component.config.SignErrorEnum;
import com.wb.sign.component.exception.SignException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @ClassName: DefaultSignCmdResolver
 * @Package: com.wb.sign.component.command.resolver
 * @Description: the default sign cmd resolver
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Component
public class DefaultSignCmdResolver implements SignCmdResolver {

    @Override
    public boolean isSupport(String action) {
        return SignCmdEnum.isSupport(action);
    }

    @Override
    public <T extends SignResult> T resolverCmdInvoke(String action, SignRequest<T> request) {
        String beanId = SignCmdEnum.getBeanId(action);
        if (StringUtils.isEmpty(beanId)) {
            throw new SignException(SignErrorEnum.INTERNAL.getMsg());
        }
        Object bean = SpringApplicationContextProvider.getBean(beanId);
        if (ObjectUtils.isEmpty(bean) || !(bean instanceof SignCommand)) {
            throw new SignException(SignErrorEnum.INTERNAL.getMsg());
        }
        SignCommand cmd = (SignCommand) bean;
        return cmd.execute(request);
    }
}
