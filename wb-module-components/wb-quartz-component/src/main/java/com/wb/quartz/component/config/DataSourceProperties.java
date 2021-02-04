package com.wb.quartz.component.config;

/**
 * @ClassName: DataSourceProperties
 * @Package: com.wb.quartz.component.client
 * @Description: the data source properties
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class DataSourceProperties {

    //  the datasource url
    private String url;

    //  the datasource user name
    private String username;

    //  the datasource password
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
