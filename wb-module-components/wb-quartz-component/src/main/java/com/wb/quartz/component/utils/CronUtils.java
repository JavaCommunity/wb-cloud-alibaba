package com.wb.quartz.component.utils;

import org.quartz.CronExpression;
import org.springframework.util.Assert;

/**
 * @ClassName: CronUtils
 * @Package: com.wb.quartz.component.utils
 * @Description: the core utils
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class CronUtils {

    /**
     * the is valid expression.
     *
     * @param cronExpression the cron expression
     * @return <tt>true</> if this corn expression is valid
     */
    public static boolean isValid(String cronExpression) {
        Assert.hasText(cronExpression, "'cronExpression' must not null！");

        return CronExpression.isValidExpression(cronExpression);
    }
}
