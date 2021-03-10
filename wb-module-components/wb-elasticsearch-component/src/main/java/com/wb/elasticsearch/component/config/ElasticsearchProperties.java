package com.wb.elasticsearch.component.config;

import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName: ElasticsearchProperties
 * @Package: com.wb.elasticsearch.component.config
 * @Description: the elasticsearch properties
 * @Author：[bo.wang]
 * @Date: 2021/3/9
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wb-cloud.elasticsearch")
public class ElasticsearchProperties {

    //  the elasticsearch default model
    private static final String DEFAULT_MODEL = "standalone";

    //  the model
    private String model = DEFAULT_MODEL;

    //  the standalone elasticsearch
    private ElasticsearchGenericProperties standalone;

    //  the cluster elasticsearch
    private Map<String, ElasticsearchGenericProperties> cluster;

    /**
     * get builder with the specified model
     *
     * @return the rest client builder
     */
    public RestClientBuilder getBuilder() {
        if (ElasticsearchModelEnum.STANDALONE.name().equalsIgnoreCase(this.model)) {
            ElasticsearchGenericProperties standalone = this.standalone;
            return RestClient.builder(new HttpHost(
                    standalone.getHostname(),
                    standalone.getPort(),
                    standalone.getScheme()
            ));
        }
        Map<String, ElasticsearchGenericProperties> cluster = this.getCluster();
        if (CollectionUtils.isEmpty(cluster)) {
            throw new ElasticsearchException("cluster http host must not be null！");
        }
        Collection<ElasticsearchGenericProperties> genericPropertiesList = cluster.values();
        return RestClient.builder(genericPropertiesList.stream().map(this::createHttpHost).toArray(HttpHost[]::new));
    }

    /**
     * create http host with the properties
     *
     * @param properties the properties
     * @return the http host
     */
    private HttpHost createHttpHost(ElasticsearchGenericProperties properties) {
        Assert.notNull(properties, "'properties' must not be null！");
        return new HttpHost(properties.getHostname(), properties.getPort(), properties.getScheme());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ElasticsearchGenericProperties getStandalone() {
        return standalone;
    }

    public void setStandalone(ElasticsearchGenericProperties standalone) {
        this.standalone = standalone;
    }

    public Map<String, ElasticsearchGenericProperties> getCluster() {
        return cluster;
    }

    public void setCluster(Map<String, ElasticsearchGenericProperties> cluster) {
        this.cluster = cluster;
    }
}
