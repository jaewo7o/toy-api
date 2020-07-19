package com.jaewoo.toy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                        .useDefaultResponseMessages(false)
                        .apiInfo(apiInfo())
                        .securitySchemes(Collections.singletonList(apiKey()))
                        .select()
                        .paths(PathSelectors.ant("/api/**/*"))
                        .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "access-token", "headers");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("toy project")
                .contact(new Contact("Jung Jaewoo", null, "jeaawoo.jeong@gmail.com"))
                .version("1.0.0")
                .build();
    }

}
