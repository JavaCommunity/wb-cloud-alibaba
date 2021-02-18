package com.wb.workflow.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: WorkFlowDatabaseProperties
 * @Package: com.wb.workflow.service.config
 * @Description: the work flow database properties
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wb-cloud.work-flow.database")
public class WorkFlowDatabaseProperties {

    //  the default database type
    private static final String DEFAULT_DATABASE_TYPE = "mysql";

    //  the database type
    private String type = DEFAULT_DATABASE_TYPE;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
