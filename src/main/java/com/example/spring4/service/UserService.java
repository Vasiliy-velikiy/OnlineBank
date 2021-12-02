package com.example.spring4.service;

import com.example.spring4.domain.entity.User;

import java.util.UUID;

/**
 * @author dkotov
 * @since 30.11.2021
 */
public interface UserService {
    User get(UUID id);

    User create(User userJson);

    User update(UUID id, User userJson);

    void delete(UUID id);
}
