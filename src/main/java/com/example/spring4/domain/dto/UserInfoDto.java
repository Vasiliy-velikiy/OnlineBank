package com.example.spring4.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

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
@Schema(name = "UserInfo", description = "Info about user")
public class UserInfoDto {
    @Schema(description = "User id",
            required = true,
            pattern = "regex",
            maxLength = 36,
            minLength = 36)
    UUID id;
    @Schema(description = "First name")
    String firstName;
    @Schema(description = "Last name")
    String lastName;
    @Schema(description = "Email")
    String email;

    @Schema(description = "Address id")
    UUID addressId;
}
