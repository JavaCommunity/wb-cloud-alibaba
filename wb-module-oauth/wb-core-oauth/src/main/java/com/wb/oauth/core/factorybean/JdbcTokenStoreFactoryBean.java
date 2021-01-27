package com.wb.oauth.core.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @ClassName: JdbcTokenStoreFactoryBean
 * @Package: com.wb.oauth.core.factorybean
 * @Description: the jdbc token store factory bean
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class JdbcTokenStoreFactoryBean implements FactoryBean<JdbcTokenStore> {

    //  the data source
    private DataSource dataSource;

    @Override
    public JdbcTokenStore getObject() throws Exception {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public Class<?> getObjectType() {
        return JdbcTokenStore.class;
    }
}
