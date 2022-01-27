package com.example.spring4.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author dkotov
 * @since 21.12.2021
 */
@Getter
@Setter
@Entity
public class Address extends BaseEntity {
    private String city;
}
