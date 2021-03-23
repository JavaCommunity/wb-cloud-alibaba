package com.wb.sign.component.config;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName: SignCmdEnum
 * @Package: com.wb.sign.component.config
 * @Description: the sign cmd enum
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public enum SignCmdEnum {

    E_BAO_CREATE_PERSON("eBaoCreatePerson", "signEBaoCreatePersonAccountCmd");

    //  the name
    private String name;

    //  the bean id
    private String beanId;

    /**
     * constructs a new sign cmd enum with the name and bean id.
     *
     * @param name   the name
     * @param beanId the bean id
     */
    SignCmdEnum(String name, String beanId) {
        this.name = name;
        this.beanId = beanId;
    }

    /**
     * check is support cmd with specified action.
     *
     * @param action the action
     * @return <tt>tue<tt/> if support
     */
    public static boolean isSupport(String action) {
        return StringUtils.isEmpty(action) ? false : Arrays.asList(SignCmdEnum.values())
                .stream().filter(type -> type.name.equalsIgnoreCase(action)).findAny().isPresent();
    }

    /**
     * get bean id with the specified action.
     *
     * @param action the action
     * @return the bean id
     */
    public static String getBeanId(String action) {
        Optional<SignCmdEnum> cmdEnumOptional = Arrays.asList(SignCmdEnum.values())
                .stream().filter(type -> type.getName().equalsIgnoreCase(action)).findFirst();
        return cmdEnumOptional.isPresent() ? cmdEnumOptional.get().beanId : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }
}
