package com.wb.workflow.service.config;

import com.wb.flowable.ext.api.config.FlowableConstants;
import com.wb.flowable.ext.api.idgenerator.DefaultFlowableIdGeneratorExt;
import com.wb.flowable.ext.api.idgenerator.FlowableIdGeneratorExt;
import org.flowable.engine.*;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName: WorkFlowConfiguration
 * @Package: com.wb.workflow.service.config
 * @Description: the work flow configuration
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties({WorkFlowDatabaseProperties.class})
public class WorkFlowConfiguration {

    @Autowired
    private WorkFlowDatabaseProperties databaseProperties;

    @Bean
    public ProcessEngineFactoryBean processEngineFactory(SpringProcessEngineConfiguration processEngineConfiguration) {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(processEngineConfiguration);
        return processEngineFactoryBean;
    }

    @Bean
    public RepositoryService repositoryService(ProcessEngineFactoryBean processEngineFactory) throws Exception {
        ProcessEngine processEngine = processEngineFactory.getObject();
        return processEngine.getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(ProcessEngineFactoryBean processEngineFactory) throws Exception {
        ProcessEngine processEngine = processEngineFactory.getObject();
        return processEngine.getRuntimeService();
    }

    @Bean
    public TaskService taskService(ProcessEngineFactoryBean processEngineFactory) throws Exception {
        ProcessEngine processEngine = processEngineFactory.getObject();
        return processEngine.getTaskService();
    }

    @Bean
    public HistoryService historyService(ProcessEngineFactoryBean processEngineFactory) throws Exception {
        ProcessEngine processEngine = processEngineFactory.getObject();
        return processEngine.getHistoryService();
    }

    @Bean
    public ManagementService managementService(ProcessEngineFactoryBean processEngineFactory) throws Exception {
        ProcessEngine processEngine = processEngineFactory.getObject();
        return processEngine.getManagementService();
    }

    @Bean
    public FlowableIdGeneratorExt flowableIdGenerator() {
        return new DefaultFlowableIdGeneratorExt(FlowableConstants.ID_PREFIX);
    }

    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration(DataSource dataSource, PlatformTransactionManager transactionManager) {
        SpringProcessEngineConfiguration processConfiguration = new SpringProcessEngineConfiguration();
        //  设置activiti 数据源
        processConfiguration.setDataSource(dataSource);
        //  通常不需要专门设置这个参数，因为它可以从数据库连接信息中自动检测得出。只有在自动检测失败时才需要设置
        processConfiguration.setDatabaseType(databaseProperties.getType());
        //  设置事务管理器
        processConfiguration.setTransactionManager(transactionManager);
        processConfiguration.setDatabaseSchemaUpdate("true");
        processConfiguration.setAsyncExecutorActivate(false);
        //  设置是否激活任务执行器
        // processConfiguration.setJobExecutorActivate(false);
        //  禁用activiti提供的用户表组表，ACT_ID_USER,ACT_ID_GROUP,ACT_ID_MEMBERSHIP
        // processConfiguration.setDbIdentityUsed(false);
        //  自定义activiti ID生成器
        processConfiguration.setIdGenerator(flowableIdGenerator());
        processConfiguration.setLabelFontName(FlowableConstants.LABEL_FONT_NAME);
        processConfiguration.setActivityFontName(FlowableConstants.ACTIVITY_FONT_NAME);
        //  开启flowable sql 日志
        processConfiguration.setEnableLogSqlExecutionTime(true);
        return processConfiguration;
    }
}
