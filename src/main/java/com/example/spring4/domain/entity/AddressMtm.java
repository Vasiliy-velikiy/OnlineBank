package com.example.spring4.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author dkotov
 * @since 10.02.2022
 */
@Getter
@Setter
@Entity
@Table(name = "addresses_mtm")
public class AddressMtm extends BaseEntity {

    @ManyToMany(mappedBy = "addressMtms")
    private Set<User> users;
}
