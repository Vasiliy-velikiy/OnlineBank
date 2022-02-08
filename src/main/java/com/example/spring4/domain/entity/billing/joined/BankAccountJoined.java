package com.example.spring4.domain.entity.billing.joined;

import com.example.spring4.domain.entity.BillingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import static com.example.spring4.domain.entity.BillingType.ACCOUNT;

/**
 * @author dkotov
 * @since 03.02.2022
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "bank_account_id") //optional
public class BankAccountJoined extends BillingDetailsJoined {
    private String bankAccount;

    @Override
    public BillingType getBillingType() {
        return ACCOUNT;
    }
}
