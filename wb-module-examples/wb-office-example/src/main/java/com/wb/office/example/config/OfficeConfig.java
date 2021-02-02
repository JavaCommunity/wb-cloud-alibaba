package com.wb.office.example.config;

import com.wb.office.component.config.OfficeConfigurer;
import com.wb.office.component.handler.OfficeFileHandler;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: OfficeConfig
 * @Package: com.wb.office.example.config
 * @Description: the office config
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Configuration
public class OfficeConfig implements OfficeConfigurer {

    @Override
    public OfficeFileHandler addOfficeFileHandler() {
        return new DefaultOfficeFileHandler();
    }
}
