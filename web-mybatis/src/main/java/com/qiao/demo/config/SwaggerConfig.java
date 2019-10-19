package com.qiao.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
/**
 * 指定开发环境 test环境才有
 */
@Profile({"dev","test"})
public class SwaggerConfig {

    @Value("${swagger.host:localhost:9500}")
    private String host;

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qiao.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo())
                .host(host)
                //.protocols(protocols)
                //.pathMapping(path)

                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("G-PAYMENT REST API")
                .description("G-PAYMENT REST API")
                //.contact(new Contact("bobo", "https://github.com/jskillcloud", "bobo@jskillcloud.com"))
                .version("V0.6.1")
                .build();
    }
}