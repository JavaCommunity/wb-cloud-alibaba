package com.wb.office.component.resolver;

import com.wb.office.component.config.SupportFileTypeEnum;
import com.wb.office.component.handler.PageOfficeHandler;
import com.wb.office.component.initializer.PageOfficeContextInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DefaultPageOfficeHandlerResolver
 * @Package: com.wb.office.component.resolver
 * @Description: the default pageOffice handler resolver
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
@Component
public class DefaultPageOfficeHandlerResolver implements PageOfficeHandlerResolver {

    @Autowired
    private PageOfficeContextInitializer contextInitializer;

    @Override
    public boolean supports(String fileTpe) {
        return SupportFileTypeEnum.isSupport(fileTpe);
    }

    @Override
    public PageOfficeHandler resolverHandler(String businessCode) {
        return contextInitializer.getLoadHandlers().get(businessCode);
    }
}
