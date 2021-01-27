package com.wb.knife4j.component.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: Knife4jProperties
 * @Package: com.wb.knife4j.component.config
 * @Description: the knife4j properties
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wb-cloud.knife4j")
public class Knife4jProperties {

    //  the title
    private String title;

    //  the terms service url
    private String termsOfServiceUrl;

    //  the version
    private String version;

    //  the contact name
    private String contactName;

    //  the contract url
    private String contactUrl;

    //  the contract email
    private String contactEmail;

    //  the scan package
    private String scanPackage;

    //  the description
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getScanPackage() {
        return scanPackage;
    }

    public void setScanPackage(String scanPackage) {
        this.scanPackage = scanPackage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
