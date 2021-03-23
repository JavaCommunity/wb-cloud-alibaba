package com.wb.sign.component.config;

/**
 * @ClassName: SignEBaoProperties
 * @Package: com.wb.sign.component.config
 * @Description: the e bao properties
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class SignEBaoProperties {

    //  the default e bao server url
    private static final String DEFAULT_SERVER_URL = "http://openapi.tsign.cn:8080/tgmonitor/rest/app!getAPIInfo2";

    //  the e bao project id
    private String projectId;

    //  the e bao project secret
    private String projectSecret;

    //  the e bao apis url
    private String apisUrl = DEFAULT_SERVER_URL;

    //  the e bao config
    private SignEBaoConfigProperties config;

    //  the e bao http config
    private SignEBaoHttpConfigProperties httConfig;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectSecret() {
        return projectSecret;
    }

    public void setProjectSecret(String projectSecret) {
        this.projectSecret = projectSecret;
    }

    public String getApisUrl() {
        return apisUrl;
    }

    public void setApisUrl(String apisUrl) {
        this.apisUrl = apisUrl;
    }

    public SignEBaoConfigProperties getConfig() {
        return config;
    }

    public void setConfig(SignEBaoConfigProperties config) {
        this.config = config;
    }

    public SignEBaoHttpConfigProperties getHttConfig() {
        return httConfig;
    }

    public void setHttConfig(SignEBaoHttpConfigProperties httConfig) {
        this.httConfig = httConfig;
    }
}
