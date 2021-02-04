package com.wb.quartz.component.config;

import com.wb.quartz.component.exception.QuartzServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: QuartzProperties
 * @Package: com.wb.quartz.component.config
 * @Description: the quartz properties
 * @Author：[bo.wang]
 * @Date: 2021/2/4
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wb-cloud.quartz")
public class QuartzProperties implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(QuartzProperties.class);

    //  the default instance id
    private static final String DEFAULT_INSTANCE_ID = "WB_CLOUD_QUARTZ";

    //  the default is clustered
    private static final String DEFAULT_IS_CLUSTERED = "false";

    //  the default table prefix
    private static final String DEFAULT_TABLE_PREFIX = "QRTZ_";

    //  the instance id
    private String instanceId = DEFAULT_INSTANCE_ID;

    //  the is clustered
    private String isClustered = DEFAULT_IS_CLUSTERED;

    //  the table prefix
    private String tablePrefix = DEFAULT_TABLE_PREFIX;

    //  the thread count
    private String treadCount = "10";

    //  the quartz datasource
    private DataSourceProperties dataSource;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getIsClustered() {
        return isClustered;
    }

    public void setIsClustered(String isClustered) {
        this.isClustered = isClustered;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getTreadCount() {
        return treadCount;
    }

    public void setTreadCount(String treadCount) {
        this.treadCount = treadCount;
    }

    public DataSourceProperties getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSourceProperties dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (ObjectUtils.isEmpty(this.dataSource)) {
            log.error("[Quartz Starter] Init DataSource Error.");
            throw new QuartzServiceException("Init DataSource Error.");
        }

        Assert.hasLength(dataSource.getUrl(), "quartz datasource url must not be null！");
        Assert.hasLength(dataSource.getUsername(), "quartz datasource username must not be null！");
        Assert.hasLength(dataSource.getPassword(), "quartz datasource password must not be null！");
    }
}
