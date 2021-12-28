package com.example.spring4.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * @author dkotov
 * @since 28.12.2021
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Test service",
        version = "1.0.0",
        description = "Do smth"))
public class SwaggerConfiguration {
}
