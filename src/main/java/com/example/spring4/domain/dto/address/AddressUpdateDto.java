package com.example.spring4.domain.dto.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author dkotov
 * @since 21.12.2021
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class AddressUpdateDto {
}
