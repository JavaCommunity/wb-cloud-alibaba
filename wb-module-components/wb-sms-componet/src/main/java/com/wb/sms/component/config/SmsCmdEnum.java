package com.wb.sms.component.config;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName: SmsCmdEnum
 * @Package: com.wb.sms.component.config
 * @Description: the sms cmd enum
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
public enum SmsCmdEnum {

    ALIYUN_SEND_SMS("aliyunSendSmsCmd", "阿里云短信发送命令"),
    ALIYUN_SEND_BATCH_SMS("aliyunSendBatchSmsCmd", "阿里云短信批量发送命令"),
    ;

    //  the cmd name -> the spring container bean id
    private String name;

    //  the cmd description
    private String description;

    /**
     * constructs a new sms cmd enum with the name and description.
     *
     * @param name        the name
     * @param description the description
     */
    SmsCmdEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * check is support cmd with specified cmd type.
     *
     * @param cmdType the cmd type
     * @return <tt>tue<tt/> if support
     */
    public static boolean isSupport(String cmdType) {
        return StringUtils.isEmpty(cmdType) ? false : Arrays.asList(SmsCmdEnum.values())
                .stream().filter(type -> type.name.equalsIgnoreCase(cmdType)).findAny().isPresent();
    }

    /**
     * get bean id with the specified cmd type.
     *
     * @param cmdType the cmd type
     * @return the bean id
     */
    public static String getBeanId(String cmdType) {
        Optional<SmsCmdEnum> cmdEnumOptional = Arrays.asList(SmsCmdEnum.values())
                .stream().filter(type -> type.name.equalsIgnoreCase(cmdType)).findFirst();
        return cmdEnumOptional.isPresent() ? cmdEnumOptional.get().name : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
