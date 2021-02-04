package com.wb.quartz.component.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.quartz.utils.ConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: QuartzConnectionProvider
 * @Package: com.wb.quartz.component.config
 * @Description: the quartz connection provider
 * @Author：[bo.wang]
 * @Date: 2021/2/3
 * @Version: 1.0
 */
public class QuartzConnectionProvider implements ConnectionProvider {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(QuartzConnectionProvider.class);

    //  the default db max cached statements pre connection
    public static final int DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION = 120;

    //  the datasource driver
    public String driver;

    //  the datasource url
    public String url;

    //  the datasource user
    public String username;

    //  the datasource password
    public String password;

    //  the max connection
    public int maxConnection;

    //  the validation query
    public String validationQuery;

    //  the validate on checkout
    private boolean validateOnCheckout;

    //  idle connection validation seconds
    private int idleConnectionValidationSeconds;

    //  the druid datasource
    private DruidDataSource datasource;

    public Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

    public void shutdown() throws SQLException {
        datasource.close();
    }

    public void initialize() throws SQLException {
        Assert.hasLength(this.driver, "'driver' must not be null！");
        Assert.state(!(this.maxConnection < 0), "max connections must be greater than zero!");

        datasource = new DruidDataSource();
        try {
            datasource.setDriverClassName(this.driver);
        } catch (Exception e) {
            log.error("[Quartz Starter] Init Quartz DataSource Error,ErrMsg:{}", e.getMessage());
        }
        datasource.setUrl(this.url);
        datasource.setUsername(this.username);
        datasource.setPassword(this.password);
        datasource.setMaxActive(10);
        datasource.setMinIdle(1);
        datasource.setMaxWait(0);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION);
        if (this.validationQuery != null) {
            datasource.setValidationQuery(this.validationQuery);
            if (!this.validateOnCheckout)
                datasource.setTestOnReturn(true);
            else
                datasource.setTestOnBorrow(true);
            datasource.setValidationQueryTimeout(this.idleConnectionValidationSeconds);
        }
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

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

    public int getMaxConnection() {
        return maxConnection;
    }

    public void setMaxConnection(int maxConnection) {
        this.maxConnection = maxConnection;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isValidateOnCheckout() {
        return validateOnCheckout;
    }

    public void setValidateOnCheckout(boolean validateOnCheckout) {
        this.validateOnCheckout = validateOnCheckout;
    }

    public int getIdleConnectionValidationSeconds() {
        return idleConnectionValidationSeconds;
    }

    public void setIdleConnectionValidationSeconds(int idleConnectionValidationSeconds) {
        this.idleConnectionValidationSeconds = idleConnectionValidationSeconds;
    }

    public DruidDataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DruidDataSource datasource) {
        this.datasource = datasource;
    }
}
