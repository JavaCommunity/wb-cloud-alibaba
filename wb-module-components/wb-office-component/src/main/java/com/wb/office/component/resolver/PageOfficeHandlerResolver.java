package com.wb.office.component.resolver;

import com.wb.office.component.handler.PageOfficeHandler;

/**
 * @ClassName: PageOfficeHandlerResolver
 * @Package: com.wb.office.component.resolver
 * @Description: the pageOffice handler resolver
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
public interface PageOfficeHandlerResolver {

    /**
     * is supports with the specified file type
     *
     * @param fileType the file type
     * @return <tt>true</tt> the support
     */
    boolean supports(String fileType);

    /**
     * resolver handler with the specified business code
     *
     * @param businessCode the business code
     * @return the pageOffice load handler
     */
    PageOfficeHandler resolverHandler(String businessCode);
}
