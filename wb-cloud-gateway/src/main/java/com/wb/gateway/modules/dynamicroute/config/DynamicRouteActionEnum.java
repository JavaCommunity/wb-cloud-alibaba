package com.wb.gateway.modules.dynamicroute.config;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName: DynamicRouteActionEnum
 * @Package: com.wb.gateway.modules.dynamicroute.config
 * @Description: the dynamic route action enum
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public enum DynamicRouteActionEnum {

    SAVE("save", "dynamicRouteSaveCmd"),
    UPDATE("update", "dynamicRouteUpdateCmd"),
    DELETE("delete", "dynamicRouteDeleteCmd");

    //  the action name
    private String name;

    //  the action bean id
    private String beanId;

    /**
     * constructs a new dynamic route action enum with the specified name and bean id
     *
     * @param name   the name
     * @param beanId the bean id
     */
    DynamicRouteActionEnum(String name, String beanId) {
        this.name = name;
        this.beanId = beanId;
    }

    /**
     * check is support with specified the action.
     *
     * @param action the action
     * @return <tt>tue<tt/> if support
     */
    public static boolean isSupport(String action) {
        return StringUtils.isEmpty(action) ? false : Arrays.asList(DynamicRouteActionEnum.values())
                .stream().filter(actionEnum -> actionEnum.name.equalsIgnoreCase(action)).findAny().isPresent();
    }

    /**
     * get bean id with the specified action.
     *
     * @param action the action
     * @return the bean id
     */
    public static String getBeanId(String action) {
        Optional<DynamicRouteActionEnum> actionEnumOptional = Arrays.asList(DynamicRouteActionEnum.values())
                .stream().filter(actionEnum -> actionEnum.name.equalsIgnoreCase(action)).findFirst();
        return actionEnumOptional.isPresent() ? actionEnumOptional.get().beanId : null;
    }
}
