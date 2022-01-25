package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.domain.mapper.UserMapper;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User get(UUID id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(UUID id, User user) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> userMapper.merge(current, user))
                .map(userRepository::save)
                .orElseThrow();
    }

    @Override
    public void delete(UUID id) {
        final User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}
