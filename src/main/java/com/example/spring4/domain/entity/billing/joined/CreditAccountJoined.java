package com.example.spring4.domain.entity.billing.joined;

import com.example.spring4.domain.entity.BillingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import static com.example.spring4.domain.entity.BillingType.CREDIT;

/**
 * @author dkotov
 * @since 03.02.2022
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "credit_account_id") //optional
public class CreditAccountJoined extends BillingDetailsJoined {
    private String cardNumber;

    @Override
    public BillingType getBillingType() {
        return CREDIT;
    }
}
