package com.example.spring4.controller;

import com.example.spring4.domain.entity.User;
import com.example.spring4.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import static java.util.UUID.fromString;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@RequiredArgsConstructor
public class UserController {
    private final ObjectMapper objectMapper;
    private final UserService userService;

    @Setter
    private UserService setterUserService;

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
