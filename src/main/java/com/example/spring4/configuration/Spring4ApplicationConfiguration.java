package com.example.spring4.configuration;

import com.example.spring4.controller.UserController;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.repository.impl.UserRepositoryImpl;
import com.example.spring4.service.UserService;
import com.example.spring4.service.impl.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dkotov
 * @since 02.12.2021
 */
@Configuration
public class Spring4ApplicationConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl(objectMapper());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImp(userRepository());
    }

    @Bean
    public UserController userController() {
        return new UserController(objectMapper(), userService());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
