package com.example.spring4.domain.dto;

import com.example.spring4.domain.dto.address.AddressCreateDto;
import com.example.spring4.validation.annotation.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author dkotov
 * @since 16.12.2021
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class UserCreateDto {
    @NotBlank(message = "{firstname.empty}")
    String firstName;
    String lastName;
    String longAsString;
    @NotNull
    @Min(value = 0)
    @Max(value = 120)
    Integer age;
    @Email
    String email;
    AddressCreateDto address;
    Set<String> someIds;
}
