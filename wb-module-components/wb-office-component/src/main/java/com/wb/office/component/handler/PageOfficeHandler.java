package com.wb.office.component.handler;

import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

/**
 * @ClassName: PageOfficeHandler
 * @Package: com.wb.office.component.handler
 * @Description: the pageOffice handler
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
public interface PageOfficeHandler {

    /**
     * the load file
     *
     * @param officeCtrl the pageOffice ctrl
     */
    void load(PageOfficeCtrl officeCtrl);

    /**
     * get page
     *
     * @return the page
     */
    default String getPage() {
        return "";
    }

    /**
     * create document
     *
     * @return the document
     */
    default Object createDocument() {
        return null;
    }
}
