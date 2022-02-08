package com.example.spring4.service;

import com.example.spring4.domain.dto.billingdetails.BillingDetailsDto;
import com.example.spring4.domain.entity.billing.singletable.BillingDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * @author dkotov
 * @since 08.02.2022
 */
public interface BillingDetailsService {
    Page<BillingDetails> get(UUID userId, Pageable pageable);

    BillingDetails create(UUID userId, BillingDetails billingDetails);

    BillingDetails update(UUID billingDetailsId, BillingDetails billingDetails);

    void delete(UUID userId, UUID billingDetailsId);
}
