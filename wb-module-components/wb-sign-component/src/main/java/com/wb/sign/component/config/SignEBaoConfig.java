package com.wb.sign.component.config;

import com.timevale.esign.sdk.tech.v3.client.ServiceClient;
import com.timevale.esign.sdk.tech.v3.client.ServiceClientManager;
import com.timevale.tech.sdk.bean.HttpConnectionConfig;
import com.timevale.tech.sdk.bean.ProjectConfig;
import com.timevale.tech.sdk.bean.SignatureConfig;
import com.timevale.tech.sdk.constants.AlgorithmType;
import com.timevale.tech.sdk.constants.HttpType;
import com.wb.sign.component.exception.SignEBaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SignEBaoConfig
 * @Package: com.wb.sign.component.config
 * @Description: the sign e bao config
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(
        name = "wb-cloud.sign.type",
        havingValue = "EBAO",
        matchIfMissing = true
)
public class SignEBaoConfig implements InitializingBean, DisposableBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(SignEBaoConfig.class);

    @Autowired
    private SignProperties signProperties;

    /**
     * create a new service client
     *
     * @return the service client
     */
    @Bean
    @ConditionalOnMissingBean
    public ServiceClient serviceClient() {
        SignEBaoProperties eBao = signProperties.geteBao();
        ProjectConfig proCfg = new ProjectConfig();
        String projectId = eBao.getProjectId();
        proCfg.setProjectId(projectId);
        proCfg.setProjectSecret(eBao.getProjectSecret());
        proCfg.setItsmApiUrl(eBao.getApisUrl());
        try {
            ServiceClientManager.registClient(proCfg, getHttpConCfg(), getSignCfg());
            return ServiceClientManager.get(projectId);
        } catch (Exception e) {
            log.error("[Sign Starter] E Bao Init Error,ErrMsg：{}", e.getMessage());
            throw new SignEBaoException(e.getMessage());
        }
    }

    /**
     * get http connect config
     *
     * @return the http connect config
     */
    private HttpConnectionConfig getHttpConCfg() {
        HttpConnectionConfig httpConCfg = new HttpConnectionConfig();
        httpConCfg.setProxyIp(null);
        httpConCfg.setProxyPort(null);
        httpConCfg.setHttpType(HttpType.HTTPS);
        httpConCfg.setRetry(null);
        httpConCfg.setTimeoutConnect(30);
        httpConCfg.setTimeoutRequest(30);
        httpConCfg.setUsername(null);
        httpConCfg.setPassword(null);
        return httpConCfg;
    }

    /**
     * get sign config
     *
     * @return the signature config
     */
    private SignatureConfig getSignCfg() {
        SignatureConfig signCfg = new SignatureConfig();
        signCfg.setAlgorithm(AlgorithmType.HMACSHA256);
        return signCfg;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[Sign Starter] E Bao Init.");
    }

    @Override
    public void destroy() throws Exception {
        SignEBaoProperties eBao = signProperties.geteBao();
        String projectId = eBao.getProjectId();
        ServiceClientManager.get(projectId);
        log.info("[Sing Starter] E Bao Destroy.");
    }
}
