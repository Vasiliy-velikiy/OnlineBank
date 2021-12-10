package com.example.spring4.controller;

import com.example.spring4.domain.entity.User;
import com.example.spring4.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;

import static java.util.UUID.fromString;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@Controller
@RequiredArgsConstructor
public class UserController {
    private final ObjectMapper objectMapper;
    private final UserService userService;

    /**
     * Return user on JSON format
     *
     * @param id user id
     * @return user on JSON format
     */
    @SneakyThrows
    public String get(String id) {
        return objectMapper.writeValueAsString(userService.get(fromString(id)));
    }

    @SneakyThrows
    public String create(String userJson) {
        User user = objectMapper.readValue(userJson, User.class);
        User created = userService.create(user);
        return objectMapper.writeValueAsString(created);
    }

    @SneakyThrows
    public String update(String id, String userJson) {
        User user = objectMapper.readValue(userJson, User.class);
        User updated = userService.update(fromString(id), user);
        return objectMapper.writeValueAsString(updated);
    }

    public void delete(String id) {
        userService.delete(fromString(id));
    }
}
