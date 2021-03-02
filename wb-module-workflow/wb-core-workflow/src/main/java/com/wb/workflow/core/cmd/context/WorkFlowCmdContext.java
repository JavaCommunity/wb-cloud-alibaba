package com.wb.workflow.core.cmd.context;

import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.exception.WorkFlowException;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WorkFlowCmdContext
 * @Package: com.wb.workflow.core.cmd.context
 * @Description: the work flow cmd context
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
public class WorkFlowCmdContext {

    //  the default context
    private static final ThreadLocal<Map<Object, Object>> DEFAULT_CONTEXT = new ThreadLocal<Map<Object, Object>>() {
        @Override
        protected Map initialValue() {
            return new HashMap<>(16);
        }
    };

    /**
     * get value with the specified cls
     *
     * @param cls the cls
     * @param <T>
     * @return
     */
    public static <T> T get(Class<T> cls) {
        Object value = DEFAULT_CONTEXT.get().get(cls);
        if (value == null) {
            throw new WorkFlowException(WorkFlowErrorEnum.NOT_FOUND.getMsg());
        }
        return (T) value;
    }

    /**
     * set value with the specified key and value
     *
     * @param key   the key
     * @param value the value
     */
    public static void set(Class<?> key, Object value) {
        DEFAULT_CONTEXT.get().put(key, value);
    }
}
