package com.wb.common.utils.id;

import java.util.UUID;

/**
 * @ClassName: UUIDUtils
 * @Package: com.wb.common.utils.id
 * @Description: the uuid utils
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class UUIDUtils {

    /**
     * get id
     *
     * @return the id
     */
    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
