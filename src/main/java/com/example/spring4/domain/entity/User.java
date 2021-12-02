package com.example.spring4.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class User {
    @With
    UUID id;
    String firstName;
    String lastName;
}
