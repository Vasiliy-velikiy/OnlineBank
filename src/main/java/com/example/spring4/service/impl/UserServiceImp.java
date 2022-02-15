package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.domain.mapper.UserMapper;
import com.example.spring4.repository.BillingDetailsRepository;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
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
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BillingDetailsRepository billingDetailsRepository;

    @Override
    public User getAndInitialize(UUID id) {
        User result = userRepository.getById(id);
        Hibernate.initialize(result);
        Hibernate.initialize(result.getSomeIds());
        Hibernate.initialize(result.getBillingDetails());
        return result;
    }

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(UUID id, User user) {
        return Optional.of(id)
                .map(this::getAndInitialize)
                .map(current -> userMapper.merge(current, user))
                .map(userRepository::save)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        billingDetailsRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }
}
