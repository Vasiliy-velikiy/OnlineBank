package com.example.spring4.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@Getter
@Setter
@Entity
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne
    private Address address;
}
