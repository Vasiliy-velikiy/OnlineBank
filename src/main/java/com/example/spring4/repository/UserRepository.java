package com.example.spring4.repository;

import com.example.spring4.domain.entity.User;

import java.util.UUID;

/**
 * @author dkotov
 * @since 02.12.2021
 */
public interface UserRepository {

    User get(UUID id);

    User create(User user);

    User update(User user);

    void delete(UUID id);
}
