package com.wb.workflow.service.config;

import com.wb.common.result.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: WorkFlowGlobalExceptionHandler
 * @Package: com.wb.workflow.service.config
 * @Description: the work flow global exception handler
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
@ControllerAdvice
public class WorkFlowGlobalExceptionHandler {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(WorkFlowGlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public R globalException(Exception e) {
        log.error("[WorkFlow Starter] Service Error,ErrMsg:{}", e.getMessage());
        return R.error(e.getMessage());
    }
}
