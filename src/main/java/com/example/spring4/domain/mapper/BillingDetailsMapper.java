package com.example.spring4.domain.mapper;


import com.example.spring4.domain.dto.billingdetails.BankAccountDto;
import com.example.spring4.domain.dto.billingdetails.BillingDetailsDto;
import com.example.spring4.domain.dto.billingdetails.CreditAccountDto;
import com.example.spring4.domain.entity.billing.singletable.BankAccount;
import com.example.spring4.domain.entity.billing.singletable.BillingDetails;
import com.example.spring4.domain.entity.billing.singletable.CreditAccount;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * @author dkotov
 * @since 16.12.2021
 */
@Mapper
public interface BillingDetailsMapper {

    default BillingDetails fromDto(BillingDetailsDto source) {
        switch (source.getBillingType()) {
            case ACCOUNT:
                return fromDto((BankAccountDto) source);
            case CREDIT:
                return fromDto((CreditAccountDto) source);
            default:
                throw new UnsupportedOperationException();
        }
    }

    default BillingDetailsDto toDto(BillingDetails source) {
        switch (source.getBillingType()) {
            case ACCOUNT:
                return toDto((BankAccount) source);
            case CREDIT:
                return toDto((CreditAccount) source);
            default:
                throw new UnsupportedOperationException();
        }
    }

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    default BillingDetails merge(@MappingTarget BillingDetails target, BillingDetails source) {
        switch (source.getBillingType()) {
            case ACCOUNT:
                return merge((BankAccount) target, (BankAccount) source);
            case CREDIT:
                return merge((CreditAccount) target, (CreditAccount) source);
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Mapping(target = "user", ignore = true)
    CreditAccount fromDto(CreditAccountDto source);

    CreditAccountDto toDto(CreditAccount source);

    @Mapping(target = "user", ignore = true)
    BankAccount fromDto(BankAccountDto source);

    BankAccountDto toDto(BankAccount source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    BankAccount merge(@MappingTarget BankAccount target, BankAccount source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    CreditAccount merge(@MappingTarget CreditAccount target, CreditAccount source);
}
