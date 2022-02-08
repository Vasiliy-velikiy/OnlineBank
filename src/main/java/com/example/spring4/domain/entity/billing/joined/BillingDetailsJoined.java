package com.example.spring4.domain.entity.billing.joined;

import com.example.spring4.domain.entity.BaseEntity;
import com.example.spring4.domain.entity.BillingType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

/**
 * @author dkotov
 * @since 03.02.2022
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = JOINED)
public abstract class BillingDetailsJoined extends BaseEntity {
    private String string;

    public abstract BillingType getBillingType();
}
