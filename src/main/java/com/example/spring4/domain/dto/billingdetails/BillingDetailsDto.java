package com.example.spring4.domain.dto.billingdetails;

import com.example.spring4.domain.entity.BillingType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

import static com.example.spring4.domain.entity.BillingType.ACCOUNT_NAME;
import static com.example.spring4.domain.entity.BillingType.CREDIT_NAME;

/**
 * @author dkotov
 * @since 08.02.2022
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "billingType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BankAccountDto.class, name = ACCOUNT_NAME),
        @JsonSubTypes.Type(value = CreditAccountDto.class, name = CREDIT_NAME)
})
public abstract class BillingDetailsDto {
    private UUID id;
    private String string;

    @JsonIgnore
    public abstract BillingType getBillingType();
}
