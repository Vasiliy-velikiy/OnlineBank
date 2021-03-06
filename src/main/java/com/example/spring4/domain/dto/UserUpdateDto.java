package com.example.spring4.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author dkotov
 * @since 16.12.2021
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class UserUpdateDto {
    String firstName;
    String lastName;
    String email;
    String longAsString;
    String password;
    int age;
}
