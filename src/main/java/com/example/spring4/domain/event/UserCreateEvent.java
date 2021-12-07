package com.example.spring4.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author dkotov
 * @since 07.12.2021
 */
@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class UserCreateEvent {
    String email;
}
