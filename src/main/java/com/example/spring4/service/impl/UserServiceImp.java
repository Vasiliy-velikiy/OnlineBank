package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.domain.mapper.UserMapper;
import com.example.spring4.repository.CustomUserRepository;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final CustomUserRepository customUserRepository;
    private final UserMapper userMapper;

    @Override
    public User get(UUID id) {
        return customUserRepository.get(id);
    }

    @Override
    public User create(User user) {
        return customUserRepository.create(user);
    }

    @Override
    public User update(UUID id, User user) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> userMapper.merge(current, user))
                .map(customUserRepository::update)
                .orElseThrow();
    }

    @Override
    public void delete(UUID id) {
        customUserRepository.delete(id);
    }
}
