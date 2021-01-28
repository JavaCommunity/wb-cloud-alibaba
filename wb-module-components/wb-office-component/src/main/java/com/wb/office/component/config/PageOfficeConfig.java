package com.wb.office.component.config;

import com.zhuozhengsoft.pageoffice.poserver.AdminSeal;
import com.zhuozhengsoft.pageoffice.poserver.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @ClassName: PageOfficeConfig
 * @Package: com.wb.office.component.config
 * @Description: the page office config
 * @Author：[bo.wang]
 * @Date: 2021/1/28
 * @Version: 1.0
 */
@Configuration
public class PageOfficeConfig {

    //  the pageOffice config file name
    private static final String PAGE_OFFICE_CONFIG_FILE_NAME = "license.lic";

    //  the default pageOffice config file path
    private static final String DEFAULT_CONFIG_FILE_PATH = "doc/license.lic";

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(PageOfficeConfig.class);

    @Bean
    public ServletRegistrationBean pageOfficeServerServlet() {
        Server server = new Server();
        server.setSysPath(getPageOfficeConfigFilePath());
        ServletRegistrationBean servletBean = new ServletRegistrationBean(server);
        servletBean.addUrlMappings("/poserver.zz");
        servletBean.addUrlMappings("/posetup.exe");
        servletBean.addUrlMappings("/pageoffice.js");
        servletBean.addUrlMappings("/jquery.min.js");
        servletBean.addUrlMappings("/pobstyle.css");
        servletBean.addUrlMappings("/sealsetup.exe");
        log.info("Init PageOffice Success.");
        return servletBean;
    }

    @Bean
    public ServletRegistrationBean pageOfficeAdminSealServlet() {
        AdminSeal adminSeal = new AdminSeal();
        adminSeal.setAdminPassword("111111");
        adminSeal.setSysPath(getPageOfficeConfigFilePath());
        ServletRegistrationBean servletBean = new ServletRegistrationBean(adminSeal);
        servletBean.addUrlMappings("/adminseal.zz");
        servletBean.addUrlMappings("/sealimage.zz");
        servletBean.addUrlMappings("/loginseal.zz");
        log.info("Init PageOffice Admin Seal Success.");
        return servletBean;
    }

    /**
     * get pageoffice config file path
     *
     * @return the pageoffice config file path
     */
    private String getPageOfficeConfigFilePath() {
        try {
            ApplicationHome applicationHome = new ApplicationHome(this.getClass());
            File file = applicationHome.getSource();
            String parentFile = file.getParentFile().toString();
            File newFile = new File(parentFile + File.separator + "doc");
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            ClassPathResource resource = new ClassPathResource(DEFAULT_CONFIG_FILE_PATH);
            String newFilePath = newFile.getPath() + File.separator + PAGE_OFFICE_CONFIG_FILE_NAME;
            FileOutputStream outputStream = new FileOutputStream(newFilePath);
            byte[] buffers = new byte[1024];
            int len = 0;
            InputStream inputStream = resource.getInputStream();
            while ((len = inputStream.read(buffers)) != -1) {
                outputStream.write(buffers, 0, len);
            }
            outputStream.close();
            inputStream.close();
            return newFile.getPath();
        } catch (Exception e) {
            log.error("Init PageOffice Config File Error,ErrMsg：{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
