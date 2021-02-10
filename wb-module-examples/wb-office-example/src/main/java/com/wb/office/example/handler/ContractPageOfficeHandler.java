package com.wb.office.example.handler;

import com.wb.office.component.annotation.PageOfficeHandler;
import com.wb.office.component.handler.AbstractPageOfficeHandler;
import com.wb.office.component.handler.PageOfficeWordHandler;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ContractPageOfficeLoadHandler
 * @Package: com.wb.office.example.handler
 * @Description: the contract pageOffice load handler
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
@Component
@PageOfficeHandler("test")
public class ContractPageOfficeHandler extends AbstractPageOfficeHandler implements PageOfficeWordHandler {

    @Override
    public void load(PageOfficeCtrl officeCtrl) {
        System.out.println("12333333333");
    }

    @Override
    public String setSaveFilePage() {
        return "http://127.0.0.1:8001/file/single/v1/download?objectId=我的测试.docx";
    }
}
