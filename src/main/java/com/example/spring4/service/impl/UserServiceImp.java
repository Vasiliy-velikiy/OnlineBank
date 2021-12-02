package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public User get(UUID id) {
        return userRepository.get(id);
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User update(UUID id, User user) {
        return userRepository.update(user.withId(id));
    }

    @Override
    public void delete(UUID id) {
        userRepository.delete(id);
    }
}
