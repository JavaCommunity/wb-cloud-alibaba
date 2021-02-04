package com.wb.quartz.component.config;

import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

/**
 * @ClassName: QuartzConfig
 * @Package: com.wb.quartz.component.client
 * @Description: the quartz configuration
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Configuration
public class QuartzConfig {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(QuartzConfig.class);

    //  the default quartz properties
    private static final Properties DEFAULT_QUARTZ_PROPERTIES = new Properties();

    @Autowired
    private QuartzProperties quartzProperties;

    static {
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.scheduler.instanceId", "AUTO");
        //  所有的quartz数据例如job和Trigger的细节信息被保存在内存或数据库中
        //  有两种实现：JobStoreTX(自己管理事务)和JobStoreCMT（application server管理事务，即全局事务JTA）
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.jobStore.driverDelegateClass",
                "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.jobStore.useProperties", "false");
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.jobStore.clusterCheckinInterval", "20000");
        //  配置数据源的名称，在后面配置数据源的时候要用到，例如org.quartz.dataSource.clusterDS.driver
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.jobStore.dataSource", "cloud");
        //  用户自定义org.quartz.utils.ConnectionProvider实现类
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.dataSource.cloud.connectionProvider.class",
                "com.wb.quartz.component.config.QuartzConnectionProvider");
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.dataSource.cloud.driver", "com.mysql.cj.jdbc.Driver");
        //  线程池的实现类
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        //  设置线程的优先级（最大为java.lang.Thread.MAX_PRIORITY 10，最小为Thread.MIN_PRIORITY 1）
        //  【默认Thread.NORM_PRIORITY (5)】【非必须】
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.threadPool.threadPriority", "5");
        //  设置是否为守护线程
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");
    }

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        QuartzAutowireBeanFactory quartzAutowire = new QuartzAutowireBeanFactory();
        quartzAutowire.setApplicationContext(applicationContext);
        return quartzAutowire;
    }

    /**
     * instantiates a new scheduler factory bean with the specified job factory
     *
     * @param jobFactory the job factory
     * @return the scheduler factory bean
     */
    @Bean
    @DependsOn({"jobFactory"})
    @ConditionalOnMissingBean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setStartupDelay(1);
        DataSourceProperties dataSource = quartzProperties.getDataSource();
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.scheduler.instanceName", quartzProperties.getInstanceId());
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.jobStore.isClustered", quartzProperties.getIsClustered());
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.jobStore.tablePrefix", quartzProperties.getTablePrefix());
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.threadPool.threadCount", quartzProperties.getTreadCount());

        //  init datasource
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.dataSource.cloud.url", dataSource.getUrl());
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.dataSource.cloud.username", dataSource.getUsername());
        DEFAULT_QUARTZ_PROPERTIES.setProperty("org.quartz.dataSource.cloud.password", dataSource.getPassword());
        schedulerFactoryBean.setQuartzProperties(DEFAULT_QUARTZ_PROPERTIES);
        return schedulerFactoryBean;
    }
}
