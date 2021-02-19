package com.wb.workflow.core.config;

import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.workflow.core.cmd.interceptor.WorkFlowCmdInterceptor;
import com.wb.workflow.core.cmd.executor.WorkFlowExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: WorkFlowStartListener
 * @Package: com.wb.workflow.core.config
 * @Description: the work flow start listener
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowStartListener implements ApplicationListener<ApplicationReadyEvent> {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(WorkFlowStartListener.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        initCmdInterceptorChain();
        log.info("[WorkFlow Starter] Start Success.");
    }

    /**
     * init cmd interceptor chain
     */
    private void initCmdInterceptorChain() {
        //  get executor bean map
        Map<String, WorkFlowExecutor> executorMap = BeanFactoryUtils
                .beansOfTypeIncludingAncestors(SpringApplicationContextProvider.applicationContext,
                        WorkFlowExecutor.class, true, false);
        if (CollectionUtils.isEmpty(executorMap)) {
            return;
        }
        //  get cmd interceptor
        Map<String, WorkFlowCmdInterceptor> cmdInterceptorMap = BeanFactoryUtils
                .beansOfTypeIncludingAncestors(SpringApplicationContextProvider.applicationContext,
                        WorkFlowCmdInterceptor.class, true, false);
        if (!CollectionUtils.isEmpty(cmdInterceptorMap)) {
            List<WorkFlowCmdInterceptor> cmdInterceptorList = cmdInterceptorMap.entrySet().stream().
                    map(var -> var.getValue()).filter(var -> var.enable()).collect(Collectors.toList());
            cmdInterceptorList.sort((WorkFlowCmdInterceptor var1, WorkFlowCmdInterceptor var2)
                    -> Integer.valueOf(var1.getOrder()).compareTo(var2.getOrder()));
            cmdInterceptorMap = null;
            for (int i = 0; i < cmdInterceptorList.size() - 1; i++) {
                WorkFlowCmdInterceptor currentCmdInterceptor = cmdInterceptorList.get(i);
                currentCmdInterceptor.setNext(cmdInterceptorList.get(i + 1));
            }
            executorMap.forEach((k, v) -> {
                v.setCmdInterceptor(cmdInterceptorList.get(0));
            });
        }
    }
}
