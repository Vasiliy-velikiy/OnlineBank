package com.example.spring4.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * @author dkotov
 * @since 01.02.2022
 */
@Getter
@Setter
@Embeddable
public class AddressEmbeddable {
    private String city;
    private String district;
    private String street;
}
