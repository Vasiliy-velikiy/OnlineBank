package com.example.spring4.service;

import com.example.spring4.domain.dto.security.LoginRequest;
import com.example.spring4.domain.dto.security.SignUpRequest;

/**
 * @author dkotov
 * @since 10.02.2022
 */
public interface AuthService {

    String login(LoginRequest loginRequest);

    String signUp(SignUpRequest signUpRequest);
}
