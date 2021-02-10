package com.wb.office.component.handler;

import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;

/**
 * @ClassName: PageOfficeWordHandler
 * @Package: com.wb.office.component.handler
 * @Description: the pageOffice word handler
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
public interface PageOfficeWordHandler extends PageOfficeHandler {

    @Override
    default String getPage() {
        return "word";
    }

    @Override
    default Object createDocument() {
        return new WordDocument();
    }
}
