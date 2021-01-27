package com.wb.oauth.core.tokenstore;

import com.wb.oauth.core.factorybean.JdbcTokenStoreFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ObjectUtils;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName: JdbcTokenStoreProperties
 * @Package: com.wb.oauth.core.tokenstore
 * @Description: the jdbc token store properties
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class JdbcTokenStoreProperties extends AbstractTokenStoreProperties {

    public JdbcTokenStoreProperties() {
        super(JdbcTokenStoreFactoryBean.class);
    }

    @Override
    public void check(DefaultListableBeanFactory beanFactory) {
        DataSource dataSource = beanFactory.getBean(DataSource.class);
        if (ObjectUtils.isEmpty(dataSource)) {
            throw new IllegalArgumentException("'dataSource' must not be null！");
        }
    }

    @Override
    public void putPropertyReference(Map<String, String> propertyReferenceMap) {
        propertyReferenceMap.put("dataSource", "dataSource");
    }
}
