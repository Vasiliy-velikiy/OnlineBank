package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.domain.entity.billing.BankAccount;
import com.example.spring4.domain.entity.billing.CreditAccount;
import com.example.spring4.domain.mapper.UserMapper;
import com.example.spring4.repository.BillingDetailsRepository;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Pair;
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
    private final UserMapper userMapper;
    private final BillingDetailsRepository billingDetailsRepository;

    @Override
    public User get(UUID id) {
        User result = userRepository.getById(id);
        Hibernate.initialize(result);
        Hibernate.initialize(result.getSomeIds());
        return result;
    }

    @Override
    public Pair<User, BankAccount> create(User user) {
        billingDetailsRepository.save(new CreditAccount("credit"));
        return Pair.of(userRepository.save(user), billingDetailsRepository.save(new BankAccount("account")));
    }

    @Override
    public void getAccount(UUID id) {
        billingDetailsRepository.getById(id).getString();
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
        userRepository.deleteById(id);
    }
}
