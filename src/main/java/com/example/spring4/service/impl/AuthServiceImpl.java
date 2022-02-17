package com.example.spring4.service.impl;

import com.example.spring4.domain.dto.security.LoginRequest;
import com.example.spring4.domain.dto.security.SignUpRequest;
import com.example.spring4.domain.entity.User;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.service.AuthService;
import com.example.spring4.service.TokenService;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author dkotov
 * @since 10.02.2022
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final TokenService tokenService;

    private final UserRepository userRepository;

    @Override
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return tokenService.generateToken(user);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public String signUp(SignUpRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userService.create(user);
        return tokenService.generateToken(user);
    }
}
