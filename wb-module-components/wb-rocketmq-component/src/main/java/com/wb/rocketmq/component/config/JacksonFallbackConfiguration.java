package com.wb.rocketmq.component.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: JacksonFallbackConfiguration
 * @Package: com.wb.rocketmq.component.config
 * @Description: the jackson fallback configuration
 * @Author：[bo.wang]
 * @Date: 2021/4/6
 * @Version: 1.0
 */
@Configuration
@ConditionalOnMissingBean(ObjectMapper.class)
public class JacksonFallbackConfiguration {

    @Bean
    public ObjectMapper rocketMQMessageObjectMapper() {
        return new ObjectMapper();
    }
}
