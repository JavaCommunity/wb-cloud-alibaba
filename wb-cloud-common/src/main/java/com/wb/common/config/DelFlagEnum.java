package com.wb.common.config;

/**
 * @ClassName: DelFlagEnum
 * @Package: com.wb.common.config
 * @Description: the del flag enum
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public enum DelFlagEnum {

    UN_DEL("1", "正常"),
    DEL("0", "已删除");

    //  the code
    private String code;

    //  the description
    private String desc;

    /**
     * constructs a new delFlagEnum with the specified code and description
     *
     * @param code the code
     * @param desc the description
     */
    DelFlagEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
