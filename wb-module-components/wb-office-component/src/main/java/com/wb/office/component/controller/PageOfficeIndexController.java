package com.wb.office.component.controller;

import com.wb.common.utils.map.MapUtils;
import com.wb.office.component.config.OfficeProperties;
import com.wb.office.component.config.PageOfficeConstant;
import com.wb.office.component.request.PageOfficeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: PageOfficeIndexController
 * @Package: com.wb.office.component.controller
 * @Description: the pageOffice index controller
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@Controller
@RequestMapping("/pageOffice/index/")
@Api(value = "PageOfficeIndexController", tags = "pageOffice主页操作API")
public class PageOfficeIndexController {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(PageOfficeIndexController.class);

    @Autowired
    private OfficeProperties officeProperties;

    @GetMapping(value = "v1/openWindow")
    @ApiOperation(value = "打开pageOffice窗口v1", notes = "打开pageOffice窗口v1")
    public ModelAndView openWindow(PageOfficeRequest request) {
        try {
            ModelAndView view = new ModelAndView(Optional.ofNullable(request.getOpenWindowPage())
                    .orElse(PageOfficeConstant.DEFAULT_OPEN_WINDOW_PAGE));
            Map<String, Object> model = view.getModel();
            Map<String, Object> beanMap = MapUtils.beanToMap(request);
            model.putAll(beanMap);

            //  set pageOffice  window size
            model.put("windowHeight", officeProperties.getWindowHeight());
            model.put("windowWidth", officeProperties.getWindowWidth());
            return view;
        } catch (Exception e) {
            log.error("[Office Starter] Load PageOffice Window Error,ErrMsg：{}", e.getMessage());
            return new ModelAndView("error");
        }
    }
}
