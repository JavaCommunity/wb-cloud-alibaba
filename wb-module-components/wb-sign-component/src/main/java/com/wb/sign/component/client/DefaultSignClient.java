package com.wb.sign.component.client;

import com.wb.sign.component.command.request.SignGenericRequest;
import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.resolver.SignCmdResolver;
import com.wb.sign.component.command.result.SignResult;
import com.wb.sign.component.config.SignErrorEnum;
import com.wb.sign.component.exception.SignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @ClassName: DefaultSignClient
 * @Package: com.wb.sign.component.client
 * @Description: the default sign client
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Component
public class DefaultSignClient implements SignClient {

    @Autowired
    private SignCmdResolver cmdResolver;

    @Override
    public <T extends SignResult> T execute(SignRequest<T> signRequest) {
        Assert.notNull(signRequest, "'signRequest' must not be null！");

        SignGenericRequest cmdRequest = (SignGenericRequest) signRequest;
        String action = cmdRequest.getAction();
        if (StringUtils.isEmpty(action)) {
            throw new SignException(SignErrorEnum.INTERNAL.getMsg());
        }
        boolean support = cmdResolver.isSupport(action);
        if (!support) {
            throw new SignException(SignErrorEnum.INTERNAL.getMsg());
        }
        return (T) cmdResolver.resolverCmdInvoke(action, signRequest);
    }
}
