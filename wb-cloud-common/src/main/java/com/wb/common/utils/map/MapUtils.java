package com.wb.common.utils.map;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MapUtils
 * @Package: com.wb.common.utils.map
 * @Description: the map utils
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class MapUtils {

    /**
     * the bean to map
     *
     * @param bean the bean
     * @param <T>
     * @return the map
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * the map to bean with specified class
     *
     * @param map the map
     * @param cls the class
     * @param <T>
     * @return the bean
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> cls) {
        T bean = null;
        try {
            bean = cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * the mao to bean
     *
     * @param map the map
     * @param obj the obj
     */
    public static void mapToBean(Map<String, Object> map, Object obj) {
        if (!CollectionUtils.isEmpty(map)) {
            BeanMap beanMap = BeanMap.create(obj);
            beanMap.putAll(map);
        }
    }
}
