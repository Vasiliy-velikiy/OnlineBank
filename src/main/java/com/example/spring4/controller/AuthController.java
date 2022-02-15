package com.example.spring4.controller;

import com.example.spring4.domain.dto.security.LoginRequest;
import com.example.spring4.domain.dto.security.SignUpRequest;
import com.example.spring4.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dkotov
 * @since 10.02.2022
 */
@RestController
@RequestMapping(path = "auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("sign-up")
    public String signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);
    }
}
