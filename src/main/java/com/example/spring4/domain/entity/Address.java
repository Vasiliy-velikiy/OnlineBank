package com.example.spring4.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.FetchType.LAZY;

/**
 * @author dkotov
 * @since 21.12.2021
 */
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {
    private String city;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
