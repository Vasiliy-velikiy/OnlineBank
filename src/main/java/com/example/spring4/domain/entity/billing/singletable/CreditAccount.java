package com.example.spring4.domain.entity.billing.singletable;

import com.example.spring4.domain.entity.BillingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static com.example.spring4.domain.entity.BillingType.CREDIT;
import static com.example.spring4.domain.entity.BillingType.CREDIT_NAME;

/**
 * @author dkotov
 * @since 03.02.2022
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(CREDIT_NAME) //optional
public class CreditAccount extends BillingDetails {
    private String cardNumber;

    @Override
    public BillingType getBillingType() {
        return CREDIT;
    }
}
