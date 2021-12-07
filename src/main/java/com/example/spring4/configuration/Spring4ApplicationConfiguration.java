package com.example.spring4.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author dkotov
 * @since 02.12.2021
 */
@Configuration
@ImportResource({"classpath*:XmlApplicationContext.xml"})
@ComponentScan(value = "com.example.spring4")
public class Spring4ApplicationConfiguration {

}
