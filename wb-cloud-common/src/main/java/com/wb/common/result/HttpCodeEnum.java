package com.wb.common.result;

/**
 * @ClassName HttpCodeEnum
 * @Description http状态码枚举
 * @Author [bo.Wang]
 * @CreateDate 2020/7/30
 * @Version 1.0
 **/
public enum HttpCodeEnum {

    SUCCESS("9999", "操作成功！"),
    ERROR("9998", "操作失败！");

    /**
     * 编码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    HttpCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
