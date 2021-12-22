package com.example.spring4.controller;

import com.example.spring4.domain.dto.UserDto;
import com.example.spring4.domain.dto.address.AddressCreateDto;
import com.example.spring4.domain.dto.address.AddressDto;
import com.example.spring4.domain.dto.address.AddressUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author dkotov
 * @since 21.12.2021
 */
@RestController
@RequestMapping(path = "addresses")
@RequiredArgsConstructor
public class AddressController {

    @GetMapping("/{addressId}")
    public AddressDto get(@PathVariable UUID addressId) {
        return null;
    }

    @PostMapping
    public AddressDto create(@RequestBody AddressCreateDto createDto) {
        return null;
    }

    @PatchMapping("/{addressId}")
    public AddressDto update(@PathVariable UUID addressId, @RequestBody AddressUpdateDto updateDto) {
        return null;
    }

    @DeleteMapping("/{addressId}")
    public void delete(@PathVariable UUID addressId) {

    }
}
