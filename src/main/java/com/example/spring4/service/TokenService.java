package com.example.spring4.service;

import com.example.spring4.domain.entity.User;

/**
 * @author dkotov
 * @since 10.02.2022
 */
public interface TokenService {
    String generateToken(User user);

    String extractUsernameAndValidate(String token);
}
