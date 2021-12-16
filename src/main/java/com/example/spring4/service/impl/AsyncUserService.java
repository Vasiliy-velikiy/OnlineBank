package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author dkotov
 * @since 14.12.2021
 */
@Service
@RequiredArgsConstructor
public class AsyncUserService {

    private final UserService userService;

    public Future<User> create(User user) {
        return CompletableFuture.supplyAsync(() -> userService.create(user));
    }
}
