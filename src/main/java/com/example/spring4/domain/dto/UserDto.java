package com.example.spring4.domain.dto;

import com.example.spring4.domain.dto.address.AddressDto;
import com.example.spring4.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author dkotov
 * @since 16.12.2021
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class UserDto {
    UUID id;
    String firstName;
    String lastName;
    String longAsString;
    int age;
    String email;
    AddressDto address;
    Role role;
    Set<String> someIds;
}
