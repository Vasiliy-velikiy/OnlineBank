package com.example.spring4.repository;

import com.example.spring4.domain.entity.billing.singletable.BillingDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.UUID;

/**
 * @author dkotov
 * @since 03.02.2022
 */
public interface BillingDetailsRepository extends JpaRepository<BillingDetails, UUID> {

    Page<BillingDetails> findAllByUserId(UUID userId, Pageable pageable);

    @Query("select billingDetails from BillingDetails billingDetails where billingDetails.user.id =:userId")
    Collection<BillingDetails> findAllByUserIdAndUserIdIn(UUID userId);

    boolean existsByUserIdAndId(UUID userId, UUID id);

    @Modifying
    void deleteByUserId(UUID userId);
}
