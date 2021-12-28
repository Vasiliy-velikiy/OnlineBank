package com.example.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Spring4Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring4Application.class);
    }
}
