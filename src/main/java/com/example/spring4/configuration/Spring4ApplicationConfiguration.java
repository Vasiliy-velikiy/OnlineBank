package com.example.spring4.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author dkotov
 * @since 02.12.2021
 */
@Configuration
@EnableAsync
@EnableScheduling
public class Spring4ApplicationConfiguration {
}
