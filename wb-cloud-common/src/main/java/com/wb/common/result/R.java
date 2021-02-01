package com.wb.common.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: R
 * @Package: com.knx.common.utils.result
 * @Description: the R
 * @Author：[bo.wang]
 * @Date: 2021/1/5
 * @Version: 1.0
 */
public class R<E> implements Serializable {

    private static final long serialVersionUID = -8075732403653477717L;

    //  the code
    private String code;

    //  the message
    private String msg;

    //  the data
    private E data = null;

    //  the attributes
    private Map<String, Object> attributes;

    /**
     * constructs a new R
     */
    public R() {
        this.code = HttpCodeEnum.SUCCESS.getCode();
        this.msg = HttpCodeEnum.SUCCESS.getMsg();
        this.attributes = new HashMap<String, Object>(16);
    }

    /**
     * constructs a new R with the specified code and message
     *
     * @param code the code
     * @param msg  the message
     */
    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * constructs a new R with the specified code and message and body
     *
     * @param code the code
     * @param msg  the message
     * @param body the body
     */
    public R(String code, String msg, E body) {
        this.code = code;
        this.msg = msg;
        this.data = body;
    }

    /**
     * Associates the specified value with the specified key in this attributes.
     *
     * @param key   the key
     * @param value the value
     * @return the R
     */
    public R put(String key, Object value) {
        this.getAttributes().put(key, value);
        return this;
    }

    /**
     * the set data
     *
     * @param data the data
     * @return the R
     */
    public R data(E data) {
        this.setData(data);
        return this;
    }

    /**
     * Instantiates a new R
     *
     * @return the R
     */
    public static R ok() {
        return new R();
    }

    /**
     * Instantiates a new R with the specified message
     *
     * @param msg the message
     * @return the R
     */
    public static R ok(String msg) {
        R r = new R();
        r.setMsg(msg);
        return r;
    }

    /**
     * Instantiates a new R with the specified map
     *
     * @param map the map
     * @return the R
     */
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.getAttributes().putAll(map);
        return r;
    }

    /**
     * Instantiates a new R
     *
     * @return the R
     */
    public static R error() {
        return error(HttpCodeEnum.ERROR.getCode(), HttpCodeEnum.ERROR.getMsg());
    }

    /**
     * Instantiates a new R with the specified message
     *
     * @param msg the message
     * @return the R
     */
    public static R error(String msg) {
        return error(HttpCodeEnum.ERROR.getCode(), msg);
    }

    /**
     * Instantiates a new R with the specified message
     *
     * @param code the code
     * @param msg  the message
     * @return the R
     */
    public static R error(String code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
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
