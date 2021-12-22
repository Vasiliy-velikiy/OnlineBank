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
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@RestController
//path = http://localhost:8080/api/v1.0/users
@RequestMapping(path = "users")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    /**
     * Return user on JSON format
     *
     * @param id user id
     * @return user on JSON format
     */
    //path = http://localhost:8080/api/v1.0/users
    @GetMapping("/{userId}")
    public UserDto get(@PathVariable(name = "userId") UUID id, @RequestParam String name, @RequestHeader Map<String, String> headers, HttpServletRequest request, HttpServletResponse response, @CookieValue Cookie cookie) {
        return Optional.of(id)
                .map(userService::get)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/info/{userId}")
    public UserInfoDto getInfo(@PathVariable(name = "userId") UUID id) {
        return Optional.of(id)
                .map(userService::get)
                .map(userMapper::toInfoDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(value = OK)
    public UserDto create(@RequestBody UserCreateDto createDto) {
        return Optional.ofNullable(createDto)
                .map(userMapper::fromCreateDto)
                .map(userService::create)
                .map(userMapper::toDto)
                .orElseThrow();
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(value = OK)
    public UserDto update(@PathVariable(name = "userId") UUID id, @RequestBody UserUpdateDto updateDto) {
        return Optional.ofNullable(updateDto)
                .map(userMapper::fromUpdateDto)
                .map(toUpdate -> userService.update(id, toUpdate))
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

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
//        final Address address = mapper.toDto(createDto);
//        return service.assignAddress(userId, address);
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

    @PatchMapping("/redirect/{userId}")
    public ModelAndView redirect(@PathVariable(name = "userId") UUID id, @RequestBody UserUpdateDto updateDto) {
        return new ModelAndView("redirect:/users/{userId}");
    }

    @PatchMapping("/forward/{userId}")
    public ModelAndView forward() {
        return new ModelAndView("forward:/users/{userId}");
    }
}
