package com.example.spring4.controller;

import com.example.spring4.domain.dto.UserCreateDto;
import com.example.spring4.domain.dto.UserDto;
import com.example.spring4.domain.dto.UserInfoDto;
import com.example.spring4.domain.dto.UserUpdateDto;
import com.example.spring4.domain.dto.address.AddressCreateDto;
import com.example.spring4.domain.dto.address.AddressDto;
import com.example.spring4.domain.dto.address.AddressUpdateDto;
import com.example.spring4.domain.exception.UserNotFoundException;
import com.example.spring4.domain.mapper.UserMapper;
import com.example.spring4.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "users")
@Tag(name = "User", description = "description")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "User not found")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    /**
     * Return user on JSON format
     *
     * @param id user id
     * @return user on JSON format
     */
    @Operation(description = "Find user by id")
    @ApiResponse(responseCode = "200", description = "User found")
    @ApiResponse(responseCode = "500", description = "User not found")
    @GetMapping("/{userId}")
    public UserDto get(@PathVariable(name = "userId") UUID id) {
        return Optional.of(id)
                .map(userService::getAndInitialize)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Operation(description = "Find user info by id")
    @ApiResponse(responseCode = "200", description = "User info found")
    @GetMapping("/info/{userId}")
    public UserInfoDto getInfo(@PathVariable(name = "userId") UUID id) {
        return Optional.of(id)
                .map(userService::getAndInitialize)
                .map(userMapper::toInfoDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Operation(description = "Create user")
    @ApiResponse(responseCode = "200", description = "User created")
    @PostMapping
    public UserDto create(@Valid @RequestBody UserCreateDto createDto) {
        return Optional.ofNullable(createDto)
                .map(userMapper::fromCreateDto)
                .map(userService::create)
                .map(userMapper::toDto)
                .orElseThrow();
    }

    @Operation(description = "Update user by id")
    @ApiResponse(responseCode = "200", description = "User updated")
    @PatchMapping("/{userId}")
    public UserDto update(@PathVariable(name = "userId") UUID id, @RequestBody UserUpdateDto updateDto) {
        return Optional.ofNullable(updateDto)
                .map(userMapper::fromUpdateDto)
                .map(toUpdate -> userService.update(id, toUpdate))
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Operation(description = "Remove user by id")
    @ApiResponse(responseCode = "204", description = "User removed")
    @DeleteMapping("/{userId}")
    @ResponseStatus(value = NO_CONTENT)
    public void delete(@PathVariable(name = "userId") UUID id) {
        userService.delete(id);
    }

    @GetMapping("/{userId}/addresses/{addressId}")
    public AddressDto getAddress(@PathVariable UUID userId, @PathVariable UUID addressId) {
        return null;
    }

    @PostMapping("/{userId}/addresses")
    public AddressDto assignAddress(@PathVariable UUID userId, @RequestBody AddressCreateDto createDto) {
        return null;
    }

    @PatchMapping("/{userId}/addresses/{addressId}")
    public AddressDto updateAddress(@PathVariable UUID userId, @PathVariable UUID addressId, @RequestBody AddressUpdateDto createDto) {
        return null;
    }

    @DeleteMapping("/{userId}/addresses/{addressId}")
    public AddressDto deleteAddress(@PathVariable UUID userId, @PathVariable UUID addressId) {
        return null;
    }
}
