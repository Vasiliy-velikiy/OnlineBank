package com.example.spring4.domain.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author dkotov
 * @since 10.02.2022
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class LoginRequest {
    String username;
    String password;
}
