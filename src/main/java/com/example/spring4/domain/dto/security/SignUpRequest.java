package com.example.spring4.domain.dto.security;

import com.example.spring4.domain.dto.UserCreateDto;
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
public class SignUpRequest {
    String username;
    String password;
}
