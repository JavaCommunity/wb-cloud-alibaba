package com.wb.dynamic.datasource.component.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.wb.dynamic.datasource.component.exception.DynamicDataSourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.sql.SQLException;

/**
 * @ClassName: DataSourceFactory
 * @Package: com.wb.dynamic.datasource.component.config
 * @Description: the datasource factory
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class DataSourceFactory {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DataSourceFactory.class);

    /**
     * the create druid datasource with specified properties
     *
     * @param properties the datasource properties
     * @return the druid datasource
     */
    public static DruidDataSource build(DataSourceProperties properties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        BeanUtils.copyProperties(properties, druidDataSource);
        try {
            druidDataSource.init();
        } catch (SQLException e) {
            log.error("Init Druid DataSource Error,ErrMsg：{}", e.getMessage());
            throw new DynamicDataSourceException("Init Druid Data Source Fail！");
        }
        return druidDataSource;
    }
}
