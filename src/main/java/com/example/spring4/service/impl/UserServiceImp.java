package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.domain.event.UserCreateEvent;
import com.example.spring4.domain.mapper.UserMapper;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
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
    private final ApplicationEventPublisher eventPublisher;
    private final UserMapper userMapper;

    @Override
    public User get(UUID id) {
        return userRepository.get(id);
    }

    @Override
    public User create(User user) {
        final User created = userRepository.create(user);
        eventPublisher.publishEvent(UserCreateEvent.builder().email(user.getEmail()).build());
        return created;
    }

    @Override
    public User update(UUID id, User user) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> userMapper.merge(current, user))
                .map(userRepository::create)
                .orElseThrow();
    }

    @Override
    public void delete(UUID id) {
        userRepository.delete(id);
    }
}
