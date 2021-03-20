package com.wb.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: MonitorAdminApplication
 * @Package: com.wb.monitor.admin
 * @Description: the monitor admin application entry
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@EnableAdminServer
@SpringBootApplication
public class MonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorAdminApplication.class, args);
    }
}
