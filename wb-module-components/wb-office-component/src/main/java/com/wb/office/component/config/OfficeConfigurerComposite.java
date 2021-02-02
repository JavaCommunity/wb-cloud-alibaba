package com.wb.office.component.config;

import com.wb.office.component.handler.OfficeFileHandler;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: OfficeConfigurerComposite
 * @Package: com.wb.office.component.config
 * @Description: the office configurer composite
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class OfficeConfigurerComposite {

    //  the configurer
    private OfficeConfigurer configurer = null;

    /**
     * the add office file handler
     *
     * @return the office file handler
     */
    protected OfficeFileHandler addOfficeFileHandler() {
        if (!ObjectUtils.isEmpty(configurer)) {
            return configurer.addOfficeFileHandler();
        }
        return null;
    }

    public void setConfigurer(OfficeConfigurer configurer) {
        this.configurer = configurer;
    }
}
