package com.example.spring4.domain.entity.billing;

import com.example.spring4.domain.entity.BaseEntity;
import com.example.spring4.domain.entity.BillingType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

/**
 * @author dkotov
 * @since 03.02.2022
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class BillingDetails extends BaseEntity {
    private String string;

    public abstract BillingType getBillingType();
}
