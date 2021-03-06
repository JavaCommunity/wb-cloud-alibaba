package com.wb.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: BaseContext
 * @Package: com.wb.common.context
 * @Description: the base context
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class BaseContext {

    //  the default context
    private static final ThreadLocal<Map<String, Object>> DEFAULT_CONTEXT = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map initialValue() {
            return new HashMap<>(16);
        }
    };

    /**
     * Associates the specified value with the specified key in this map.
     *
     * @param key   the key
     * @param value the value
     */
    public static void put(String key, Object value) {
        DEFAULT_CONTEXT.get().put(key, value);
    }

    /**
     * get with the specified key
     *
     * @param key the key
     * @return the object
     */
    public static Object get(String key) {
        return DEFAULT_CONTEXT.get().get(key);
    }

    /**
     * clear all default context
     */
    public static void clear() {
        DEFAULT_CONTEXT.get().clear();
    }
}
