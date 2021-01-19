package com.wb.common.result;

/**
 * @ClassName GlobalCodeEnum
 * @Description 全局状态码枚举
 * @Author [bo.Wang]
 * @CreateDate 2020/7/30
 * @Version 1.0
 **/
public enum GlobalCodeEnum {

    SUCCESS("200");

    private String code;

    GlobalCodeEnum(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
