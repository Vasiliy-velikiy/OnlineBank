package com.example.spring4.controller;

import com.example.spring4.domain.dto.billingdetails.BillingDetailsDto;
import com.example.spring4.domain.mapper.BillingDetailsMapper;
import com.example.spring4.service.BillingDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

/**
 * @author dkotov
 * @since 08.02.2022
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class BillingDetailsController {
    private final BillingDetailsMapper billingDetailsMapper;
    private final BillingDetailsService billingDetailsService;

    @GetMapping(path = "users/{userId}/billing-details")
    public Page<BillingDetailsDto> get(@PathVariable UUID userId, Pageable pageable) {
        return Optional.of(userId)
                .map(it -> billingDetailsService.get(userId, pageable))
                .map(it -> it.map(billingDetailsMapper::toDto))
                .orElseThrow();
    }

    @PostMapping(path = "users/{userId}/billing-details")
    public BillingDetailsDto create(@PathVariable UUID userId, @RequestBody BillingDetailsDto billingDetailsDto) {
        return Optional.of(billingDetailsDto)
                .map(billingDetailsMapper::fromDto)
                .map(it -> billingDetailsService.create(userId, it))
                .map(billingDetailsMapper::toDto)
                .orElseThrow();
    }

    @PatchMapping(path = "billing-details/{billingDetailsId}")
    public BillingDetailsDto update(@PathVariable UUID billingDetailsId, @RequestBody BillingDetailsDto billingDetailsDto) {
        return Optional.of(billingDetailsDto)
                .map(billingDetailsMapper::fromDto)
                .map(it -> billingDetailsService.update(billingDetailsId, it))
                .map(billingDetailsMapper::toDto)
                .orElseThrow();
    }

    @DeleteMapping(path = "users/{userId}/billing-details/{billingDetailsId}")
    public void delete(@PathVariable UUID userId, @PathVariable UUID billingDetailsId) {
        billingDetailsService.delete(userId, billingDetailsId);
    }
}
