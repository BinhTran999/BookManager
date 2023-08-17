package com.cc.bookmanager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig {
    @Bean
    public OpenAPI gateWayOpenApi() {
        return new OpenAPI().info(new Info().title("Master Data APIs ")
                .description("Documentation for all the APIs in Master Data Service")
                .version("v1.0.0")
                .license(new License().name("©Copyright 2023 MPLIS").url("https://google.com"))
                .contact(new Contact().name("Support").email("abc@gmail.com")));
    }
}