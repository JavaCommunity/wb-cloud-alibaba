package com.wb.elasticsearch.component.config;

/**
 * @ClassName: ElasticsearchGenericProperties
 * @Package: com.wb.elasticsearch.component.config
 * @Description: the elasticsearch generic properties
 * @Author：[bo.wang]
 * @Date: 2021/3/9
 * @Version: 1.0
 */
public class ElasticsearchGenericProperties {

    //  the host name
    private String hostname;

    //  the port
    private int port = 9200;

    //  the scheme
    private String scheme = "http";

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
