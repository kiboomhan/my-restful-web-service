package com.example.restfulwebservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("Kenneth Lee", "http://leanject.com", "kiboomhan@gmail.com");

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/xml"));

    @Bean
    public Docket api() {
//        return new Docket(DocumentationType.OAS_30);
        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(false) // Swagger 에서 제공해주는 기본 응답 코드 (200, 401, 403, 404)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.restfulwebservice")) // api 스팩이 작송되어 있는 패키지 지정
//                .paths(PathSelectors.any()) // apis에 있는 API 중 특정 path를 지정
//                .build()
                .apiInfo(apiInfo());
//                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
//                .consumes(DEFAULT_PRODUCES_AND_CONSUMES); // Swagger UI로 노출할 정보
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful Web Service")
                .description("practice swagger config")
                .version("1.0")
                .termsOfServiceUrl("urn:tos")
                .contact(DEFAULT_CONTACT)
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .extensions(new ArrayList<>())
                .build();
    }
}
