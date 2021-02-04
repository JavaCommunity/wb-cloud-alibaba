package com.wb.quartz.component.config;

import org.springframework.util.StringUtils;

/**
 * @ClassName: MisfireTypeEnum
 * @Package: com.wb.quartz.component.client
 * @Description: the misfire type enum
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public enum MisfireTypeEnum {

    /**
     * 不触发立即执行
     * 等待下次Cron触发频率到达时刻开始按照Cron频率依次执行
     */
    DO_NOTHING,

    /**
     * 以错过的第一个频率时间立刻开始执行
     * 重做错过的所有频率周期后
     * 当下一次触发频率发生时间大于当前时间后，再按照正常的Cron频率依次执行
     */
    IGNORE_MISFIRES,

    /**
     * 以当前时间为触发频率立刻触发一次执行
     * 然后按照Cron频率依次执行
     */
    FIRE_AND_PROCEED;

    /**
     * get misfire type with the specified key
     *
     * @param key the key
     * @return the misfire type enum
     */
    public static MisfireTypeEnum getMisfireType(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        for (MisfireTypeEnum misfireType : MisfireTypeEnum.values()) {
            if (misfireType.name().equalsIgnoreCase(key)) {
                return misfireType;
            }
        }
        return null;
    }
}
