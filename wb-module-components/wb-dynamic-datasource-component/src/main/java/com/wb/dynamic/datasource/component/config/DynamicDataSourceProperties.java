package com.wb.dynamic.datasource.component.config;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: DynamicDataSourceProperties
 * @Package: com.wb.dynamic.datasource.component.config
 * @Description: the dynamic datasource properties
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class DynamicDataSourceProperties {

    //  the dynamic datasource
    private Map<String, DataSourceProperties> datasource = new LinkedHashMap<>();

    public Map<String, DataSourceProperties> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, DataSourceProperties> datasource) {
        this.datasource = datasource;
    }
}
