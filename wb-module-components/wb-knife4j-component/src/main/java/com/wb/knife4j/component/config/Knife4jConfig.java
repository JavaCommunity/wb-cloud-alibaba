package com.wb.knife4j.component.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName: Knife4jConfig
 * @Package: com.wb.knife4j.component.config
 * @Description: the knife4j config
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@Configuration
public class Knife4jConfig {

    @Autowired
    private Knife4jProperties knife4jProperties;

    /**
     * constructs a new docket
     *
     * @return Docket the docket
     */
    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(knife4jProperties.getScanPackage()))
                .paths(PathSelectors.any()).build();
    }

    /**
     * instantiates a new api info
     *
     * @return ApiInfo the api info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(knife4jProperties.getTitle())
                .description(knife4jProperties.getDescription())
                .termsOfServiceUrl(knife4jProperties.getTermsOfServiceUrl())
                .contact(new Contact(knife4jProperties.getContactName(), knife4jProperties.getContactUrl(), knife4jProperties.getContactEmail()))
                .version(knife4jProperties.getVersion())
                .build();
    }
}
