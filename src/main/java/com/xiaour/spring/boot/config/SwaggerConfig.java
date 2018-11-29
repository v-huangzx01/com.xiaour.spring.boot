package com.xiaour.spring.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by liujl15 on 2017/3/30.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.host}")
    private String swagger_host;

    @Bean
    public Docket createRestApi() {
        System.out.println("swaggerhost:" + swagger_host);
        return new Docket(DocumentationType.SWAGGER_2).host(swagger_host)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaour.spring.boot"))
                //.apis(RequestHandlerSelectors.basePackage("com.vanke.Emergencies.rest.devrest"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("这是投票工程的文档")
                .contact("hua")
                .version("1.0")
                .build();
    }


}
