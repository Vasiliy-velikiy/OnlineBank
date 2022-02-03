package com.example.spring4.repository;

import com.example.spring4.domain.entity.User;

import java.util.UUID;

/**
 * @author dkotov
 * @since 25.01.2022
 */
public interface CustomUserRepository {
    User get(UUID id);

    User create(User user);

    User update(User user);

    void delete(UUID id);
}
