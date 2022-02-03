package com.example.spring4.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

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
}
