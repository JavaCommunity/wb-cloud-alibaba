package com.wb.dynamic.datasource.component.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.wb.dynamic.datasource.component.exception.DynamicDataSourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DefaultRoutingDataSource
 * @Package: com.wb.dynamic.datasource.component.config
 * @Description: the default routing datasource
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class DefaultRoutingDataSource extends AbstractRoutingDataSource {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DefaultRoutingDataSource.class);

    @Autowired
    private DynamicDataSourceProperties dynamicDataSource;

    @Autowired
    private DataSourceProperties defaultDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        String currentDataSource = DynamicDataSourceContext.getCurrentDataSource();
        log.info("[Dynamic Datasource Starter] Determine Current Dynamic DataSource：{}", currentDataSource);
        return currentDataSource;
    }

    @Override
    public void afterPropertiesSet() {
        //  set default datasource
        super.setDefaultTargetDataSource(DataSourceFactory.build(defaultDataSource));

        Map<String, DataSourceProperties> dynamicDatasourceMap = dynamicDataSource.getDatasource();
        if (CollectionUtils.isEmpty(dynamicDatasourceMap)) {
            throw new DynamicDataSourceException("'dynamic datasource' must not be null！");
        }
        //  create hashMap with specified size
        Map<Object, Object> targetDataSource = new HashMap<>(dynamicDatasourceMap.size());
        dynamicDatasourceMap.forEach((k, v) -> {
            DruidDataSource druidDataSource = DataSourceFactory.build(v);
            targetDataSource.put(k, druidDataSource);
        });
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }
}
