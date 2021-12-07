package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author dkotov
 * @since 07.12.2021
 */
@Service
public class UserServiceStub implements UserService {
    @Override
    public User get(UUID id) {
        return null;
    }

    @Override
    public User create(User userJson) {
        return null;
    }

    @Override
    public User update(UUID id, User userJson) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
