package com.wb.office.component.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: OfficeProperties
 * @Package: com.wb.office.component.config
 * @Description: the office properties
 * @Author：[bo.wang]
 * @Date: 2021/1/28
 * @Version: 1.0
 */
@ConfigurationProperties("wb-cloud.office")
public class OfficeProperties {

    //  the default window width
    private static final String DEFAULT_WINDOW_WIDTH = "1200px";

    //  the default window height
    private static final String DEFAULT_WINDOW_HEIGHT = "1000px";

    //  the pageOffice window width
    private String windowWidth = DEFAULT_WINDOW_WIDTH;

    //  the pageOffice window height
    private String windowHeight = DEFAULT_WINDOW_HEIGHT;

    //  save max file size
    private int saveMaxFileSize = 1000000;

    public String getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(String windowWidth) {
        this.windowWidth = windowWidth;
    }

    public String getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(String windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getSaveMaxFileSize() {
        return saveMaxFileSize;
    }

    public void setSaveMaxFileSize(int saveMaxFileSize) {
        this.saveMaxFileSize = saveMaxFileSize;
    }
}
