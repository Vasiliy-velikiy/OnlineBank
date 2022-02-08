package com.example.spring4.domain.dto.billingdetails;

import com.example.spring4.domain.entity.BillingType;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import static com.example.spring4.domain.entity.BillingType.CREDIT;

/**
 * @author dkotov
 * @since 08.02.2022
 */
@Value
@Jacksonized
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CreditAccountDto extends BillingDetailsDto {
    String cardNumber;

    @Override
    public BillingType getBillingType() {
        return CREDIT;
    }
}
