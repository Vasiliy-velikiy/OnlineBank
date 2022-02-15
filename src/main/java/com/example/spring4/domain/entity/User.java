package com.example.spring4.domain.entity;

import com.example.spring4.domain.entity.billing.singletable.BillingDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeConverter;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.spring4.domain.entity.Role.ADMIN;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

/**
 * @author dkotov
 * @since 30.11.2021
 */
@Getter
@Setter
@Entity
@Table(name = "users")
@AttributeOverrides(value = {
        @AttributeOverride(name = "id", column = @Column(name = "user_id", columnDefinition = "varchar(36)"))
})
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String password;
    @Convert(converter = Converter.class)
    private String longAsString;
    private String email;
    private Integer age;
    @Enumerated(STRING)
    private Role role = ADMIN;
    @Embedded
    private AddressEmbeddable addressEmbeddable;
    @OneToOne(fetch = LAZY, mappedBy = "user", optional = false)
    private Address address;

    @Setter(PRIVATE)
    @OneToMany(mappedBy = "user",
            orphanRemoval = true,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private List<BillingDetails> billingDetails = new ArrayList<>();

    @Setter(PRIVATE)
    @ManyToMany
    @JoinTable(
            name = "user_address_mtm",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<AddressMtm> addressMtms;

    @ElementCollection
    @CollectionTable(name = "someObjects",
            joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "some_id")
    private Set<String> someIds = new HashSet<>();

    public static class Converter implements AttributeConverter<String, Long> {

        @Override
        public Long convertToDatabaseColumn(String attribute) {
            return attribute == null ? null : Long.parseLong(attribute);
        }

        @Override
        public String convertToEntityAttribute(Long dbData) {
            return dbData == null ? null : dbData.toString();
        }
    }

    public void addBillingDetails(BillingDetails billingDetails) {
        this.billingDetails.add(billingDetails);
        billingDetails.setUser(this);
    }

    public void addAddressMtm(AddressMtm addressMtm) {
        addressMtms.add(addressMtm);
        addressMtm.getUsers().add(this);
    }

    public void removeBillingDetails(BillingDetails billingDetails) {
        this.billingDetails.remove(billingDetails);
    }
}
