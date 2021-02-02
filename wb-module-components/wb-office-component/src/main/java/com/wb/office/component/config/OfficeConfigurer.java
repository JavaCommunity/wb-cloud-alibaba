package com.wb.office.component.config;

import com.wb.office.component.handler.OfficeFileHandler;

/**
 * @ClassName: OfficeConfigurer
 * @Package: com.wb.office.component.config
 * @Description: the office configurer
 * @Author：[bo.wang]
 * @Date: 2021/2/1
 * @Version: 1.0
 */
public interface OfficeConfigurer {

    /**
     * the add office file handler
     *
     * @return the office file handler
     */
    default OfficeFileHandler addOfficeFileHandler() {
        return null;
    }
}
