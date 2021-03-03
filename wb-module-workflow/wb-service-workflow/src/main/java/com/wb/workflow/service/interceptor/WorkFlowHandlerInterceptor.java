package com.wb.workflow.service.interceptor;

import com.wb.common.wrapper.SysUserWrapper;
import com.wb.workflow.core.cmd.context.WorkFlowCmdContext;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: WorkFlowHandlerInterceptor
 * @Package: com.wb.workflow.service.interceptor
 * @Description: the work flow handler interceptor
 * @Author：[bo.wang]
 * @Date: 2021/3/3
 * @Version: 1.0
 */
public class WorkFlowHandlerInterceptor implements HandlerInterceptor {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(WorkFlowHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>【WorkFlow】 handler start<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        //  TODO 暂时写测试的实现
        SysUserWrapper userWrapper = new SysUserWrapper();
        userWrapper.setName("张三");
        userWrapper.setId("111111111111");
        userWrapper.setCreateOrg("技术部");
        userWrapper.setCreateOrgId("222222222222222222222");
        WorkFlowContextHolder.setCurrentUser(userWrapper);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        WorkFlowCmdContext.clear();
        WorkFlowContextHolder.clear();
    }
}
