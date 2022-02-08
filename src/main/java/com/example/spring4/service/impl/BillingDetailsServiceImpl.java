package com.example.spring4.service.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.domain.entity.billing.singletable.BillingDetails;
import com.example.spring4.domain.mapper.BillingDetailsMapper;
import com.example.spring4.repository.BillingDetailsRepository;
import com.example.spring4.service.BillingDetailsService;
import com.example.spring4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * @author dkotov
 * @since 08.02.2022
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BillingDetailsServiceImpl implements BillingDetailsService {
    private final BillingDetailsRepository billingDetailsRepository;
    private final BillingDetailsMapper billingDetailsMapper;
    private final UserService userService;

    @Override
    public Page<BillingDetails> get(UUID userId, Pageable pageable) {
        return billingDetailsRepository.findAllByUserId(userId, pageable);
    }

    @Override
    @Transactional
    public BillingDetails create(UUID userId, BillingDetails billingDetails) {
        final User user = userService.getAndInitialize(userId);
        user.addBillingDetails(billingDetails);
        return billingDetailsRepository.save(billingDetails);
    }

    @Override
    @Transactional
    public BillingDetails update(UUID billingDetailsId, BillingDetails billingDetails) {
        return Optional.of(billingDetailsId)
                .map(billingDetailsRepository::getById)
                .map(current -> billingDetailsMapper.merge(current, billingDetails))
                .map(billingDetailsRepository::save)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void delete(UUID userId, UUID billingDetailsId) {
        final BillingDetails toDelete = billingDetailsRepository.findById(billingDetailsId).orElseThrow();
        userService.getAndInitialize(userId).removeBillingDetails(toDelete);
    }
}
