package com.wb.common.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName: R
 * @Package: com.knx.common.utils.result
 * @Description: 前后端交互统一返回对象
 * @Author：[bo.wang]
 * @Date: 2021/1/5
 * @Version: 1.0
 */
public class R<E> implements Serializable {

    private static final long serialVersionUID = -8075732403653477717L;

    /**
     * code 码
     */
    private String code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private E data = null;

    /**
     * 其他属性
     */
    private Map<String, Object> attributes;

    public R() {
        this.code = HttpCodeEnum.SUCCESS.getCode();
        this.msg = HttpCodeEnum.SUCCESS.getMsg();
        this.attributes = new HashMap<String, Object>(16);
    }

    public R(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public R(String code, String message, E body) {
        this.code = code;
        this.msg = message;
        this.data = body;
    }

    public R put(String key, Object value) {
        this.getAttributes().put(key, value);
        return this;
    }

    public R data(E data) {
        this.setData(data);
        return this;
    }

    public static R error() {
        return error(HttpCodeEnum.ERROR.getCode(), HttpCodeEnum.ERROR.getMsg());
    }

    public static R error(String msg) {
        return error(HttpCodeEnum.ERROR.getCode(), msg);
    }

    public static R error(String code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.setMsg(msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.getAttributes().putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    /**
     * 返回是否成功
     *
     * @return
     */
    public boolean isOk() {
        return Objects.equals(this.code, HttpCodeEnum.SUCCESS.getCode());
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

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
