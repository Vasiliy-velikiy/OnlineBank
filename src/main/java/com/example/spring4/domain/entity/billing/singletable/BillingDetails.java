package com.example.spring4.domain.entity.billing.singletable;

import com.example.spring4.domain.entity.BaseEntity;
import com.example.spring4.domain.entity.BillingType;
import com.example.spring4.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.*;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

/**
 * @author dkotov
 * @since 03.02.2022
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = SINGLE_TABLE) //optional
@DiscriminatorColumn(name = "billing_type") //optional
public abstract class BillingDetails extends BaseEntity {
    private String string;

    @ManyToOne(fetch = LAZY)
    private User user;

    public abstract BillingType getBillingType();
}
