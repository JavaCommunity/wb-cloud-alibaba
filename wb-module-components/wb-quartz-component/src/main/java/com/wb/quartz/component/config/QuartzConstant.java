package com.wb.quartz.component.config;

/**
 * @ClassName: QuartzConstant
 * @Package: com.wb.quartz.component.client
 * @Description: the quartz constant
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public interface QuartzConstant {

    //  the quartz default misfire type
    MisfireTypeEnum DEFAULT_MISFIRE_TYPE = MisfireTypeEnum.DO_NOTHING;

    //  the quartz default job data map key
    String DEFAULT_JOB_DATA_MAP_KEY = "simple_job";

    //  the default job key prefix
    String DEFAULT_JON_KEY_PREFIX = "WB_CLOUD_QUARTZ_";

    //  the default trigger key prefix
    String DEFAULT_TRIGGER_KEY_PREFIX = "WB_CLOUD_QUARTZ_";
}
