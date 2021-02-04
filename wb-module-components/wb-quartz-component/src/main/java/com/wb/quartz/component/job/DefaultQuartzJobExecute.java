package com.wb.quartz.component.job;

import com.wb.quartz.component.exception.QuartzServiceException;
import com.wb.quartz.component.utils.MethodUtils;
import com.wb.quartz.component.vo.QuartzJobVo;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @ClassName: DefaultQuartzJobExecute
 * @Package: com.wb.quartz.component.job
 * @Description: the default quartz job execute
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Component
public class DefaultQuartzJobExecute implements QuartzJobExecute {

    @Override
    public void execute(QuartzJobVo jobVo, JobExecutionContext jobExecutionContext) throws QuartzServiceException {
        try {
            Assert.notNull(jobVo, "'jobVo' must not null！");

            MethodUtils.invoke(jobVo, jobExecutionContext);
        } catch (Exception e) {
            throw new QuartzServiceException(e.getMessage());
        }
    }
}
