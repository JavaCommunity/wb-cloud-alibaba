package com.wb.sign.component.config;

/**
 * @ClassName: SignEBaoHttpConfigProperties
 * @Package: com.wb.sign.component.config
 * @Description: the sign e bao http config properties
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class SignEBaoHttpConfigProperties {

    //  the proxy ip
    private String proxyIp;

    //  the proxy port
    private Integer proxyPort;

    //  the http type
    private String httpType = "https";

    //  the retry
    private Integer retry = 5;

    //  the timeout connect
    private Integer timeoutConnect = 30;

    //  the timeout request
    private Integer timeoutRequest = 30;

    //  the username
    private String username;

    //  the password
    private String password;

    public String getProxyIp() {
        return proxyIp;
    }

    public void setProxyIp(String proxyIp) {
        this.proxyIp = proxyIp;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getHttpType() {
        return httpType;
    }

    public void setHttpType(String httpType) {
        this.httpType = httpType;
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }

    public Integer getTimeoutConnect() {
        return timeoutConnect;
    }

    public void setTimeoutConnect(Integer timeoutConnect) {
        this.timeoutConnect = timeoutConnect;
    }

    public Integer getTimeoutRequest() {
        return timeoutRequest;
    }

    public void setTimeoutRequest(Integer timeoutRequest) {
        this.timeoutRequest = timeoutRequest;
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
