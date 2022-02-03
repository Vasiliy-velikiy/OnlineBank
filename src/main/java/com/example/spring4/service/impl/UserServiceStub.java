package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.domain.entity.billing.BankAccount;
import com.example.spring4.service.UserService;
import org.springframework.data.util.Pair;
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
    public Pair<User, BankAccount> create(User userJson) {
        return null;
    }

    @Override
    public void getAccount(UUID id) {

    }


    @Override
    public User update(UUID id, User userJson) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
