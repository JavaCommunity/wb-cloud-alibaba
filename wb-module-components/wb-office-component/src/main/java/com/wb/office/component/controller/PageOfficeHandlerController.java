package com.wb.office.component.controller;

import com.wb.office.component.config.PageOfficeConstant;
import com.wb.office.component.handler.AbstractPageOfficeHandler;
import com.wb.office.component.handler.OfficeFileHandler;
import com.wb.office.component.handler.PageOfficeHandler;
import com.wb.office.component.request.PageOfficeRequest;
import com.wb.office.component.resolver.PageOfficeHandlerResolver;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: PageOfficeHandlerController
 * @Package: com.wb.office.component.controller
 * @Description: the pageOffice handler controller
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@Controller
@RequestMapping("/pageOffice/handler/")
@Api(value = "PageOfficeHandlerController", tags = "pageOffice处理控制器器")
public class PageOfficeHandlerController {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(PageOfficeHandlerController.class);

    @Autowired
    private OfficeFileHandler fileHandler;

    @Autowired
    private PageOfficeHandlerResolver handlerResolver;

    @RequestMapping(value = "v1/load", method = RequestMethod.GET)
    @ApiOperation(value = "PageOffice加载文件入口v1", notes = "PageOffice加载文件入口v1")
    public ModelAndView v1Load(PageOfficeRequest request, HttpServletRequest servletRequest) {
        try {
            boolean isSupport = handlerResolver.supports("doc");
            if (!isSupport) {
                return new ModelAndView("not_support");
            }

            PageOfficeHandler handler = handlerResolver.resolverHandler(request.getBusinessCode());
            if (ObjectUtils.isEmpty(handler)) {
                return new ModelAndView("not_support");
            }
            AbstractPageOfficeHandler abstractHandler = (AbstractPageOfficeHandler) handler;
            PageOfficeCtrl pageOfficeCtrl = new PageOfficeCtrl(servletRequest);
            abstractHandler.doLoad(handler, pageOfficeCtrl);
            ModelAndView view = new ModelAndView(handler.getPage());
            pageOfficeCtrl.setServerPage(PageOfficeConstant.SERVER_PAGE);
            pageOfficeCtrl.setWriter(handler.createDocument());
            view.addObject("pageoffice", pageOfficeCtrl.getHtmlCode("PageOfficeCtrl1"));
            return view;
        } catch (Exception e) {
            log.error("[Office Starter] PageOffice Load Error,ErrMsg:{}", e.getMessage());
            return new ModelAndView("error");
        }
    }
}
