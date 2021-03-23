package com.wb.sign.component.config;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName: SignTypeEnum
 * @Package: com.wb.sign.component.config
 * @Description: the sign type enum
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public enum SignTypeEnum {

    EBAO;

    /**
     * get sign type with the specified name
     *
     * @param name the name
     * @return the sign type enum
     */
    public static SignTypeEnum get(String name) {
        Optional<SignTypeEnum> signTypeEnum = Arrays.asList(SignTypeEnum.values())
                .stream().filter(type -> type.name().equalsIgnoreCase(name)).findFirst();
        return signTypeEnum.isPresent() ? signTypeEnum.get() : null;
    }
}
