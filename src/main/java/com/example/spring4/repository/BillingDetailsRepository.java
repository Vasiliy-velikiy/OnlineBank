package com.example.spring4.repository;

import com.example.spring4.domain.entity.billing.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author dkotov
 * @since 03.02.2022
 */
public interface BillingDetailsRepository extends JpaRepository<BillingDetails, UUID> {
}
