package com.example.spring4.domain.dto;

import com.example.spring4.domain.dto.address.AddressUpdateDto;
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
    int age;
}
