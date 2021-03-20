package com.wb.gateway.modules.dynamicroute.config;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName: LbTypeEnum
 * @Package: com.wb.gateway.modules.dynamicroute.config
 * @Description: the lb type enum
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public enum LbTypeEnum {

    LB(0, "lb://"),
    LB_WS(1, "lb:ws://"),
    LB_WSS(2, "lb:wss://");

    //  the lb type
    private final int type;

    //  the lb type name
    private final String typeName;

    /**
     * constructs a new lb type enum with the specified type and type name.
     *
     * @param type     the type
     * @param typeName the type name
     */
    LbTypeEnum(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    /**
     * check is exist with the type.
     *
     * @param type the type
     * @return <tt>tue<tt/> if support
     */
    public static boolean isExist(int type) {
        return StringUtils.isEmpty(type) ? false : Arrays.asList(LbTypeEnum.values())
                .stream().filter(lbType -> lbType.type == type).findAny().isPresent();
    }

    /**
     * get lb type enum with the specified type.
     *
     * @param type the type
     * @return the lb type enum
     */
    public static LbTypeEnum get(int type) {
        Optional<LbTypeEnum> lbTypeEnumOptional = Arrays.asList(LbTypeEnum.values())
                .stream().filter(lbTypeEnum -> lbTypeEnum.type == type).findFirst();
        return lbTypeEnumOptional.isPresent() ? lbTypeEnumOptional.get() : null;
    }

    public int getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }
}
