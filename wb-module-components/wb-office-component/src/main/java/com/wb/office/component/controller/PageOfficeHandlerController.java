package com.wb.office.component.controller;

import com.wb.office.component.request.PageOfficeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "v1/loadFile", method = RequestMethod.GET)
    @ApiOperation(value = "PageOffice加载文件入口v1", notes = "PageOffice加载文件入口v1")
    public ModelAndView v1LoadFile(PageOfficeRequest request, HttpServletRequest servletRequest) {
        ModelAndView view = null;
        try {
            //  TODO 判断是否是支持的文件类型
            //  TODO 加载文件
            //  TODO 解析文件对应的处理器
        } catch (Exception e) {
            e.printStackTrace();
            view = new ModelAndView("error");
        }
        return view;
    }
}
