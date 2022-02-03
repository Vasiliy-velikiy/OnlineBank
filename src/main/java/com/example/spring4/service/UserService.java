package com.example.spring4.service;

import com.example.spring4.domain.entity.User;
import com.example.spring4.domain.entity.billing.BankAccount;
import org.springframework.data.util.Pair;

import java.util.UUID;

/**
 * @author dkotov
 * @since 30.11.2021
 */
public interface UserService {
    User get(UUID id);

    Pair<User, BankAccount> create(User userJson);

   void getAccount(UUID id);

    User update(UUID id, User userJson);

    void delete(UUID id);
}
