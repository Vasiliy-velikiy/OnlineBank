package com.example.spring4.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeConverter;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static com.example.spring4.domain.entity.Role.ADMIN;
import static javax.persistence.EnumType.STRING;

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
    @Convert(converter = Converter.class)
    private String lastName;
    private String email;
    private Integer age;
    @Enumerated(STRING)
    private Role role = ADMIN;
    @Embedded
    private AddressEmbeddable addressEmbeddable;
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    public static class Converter implements AttributeConverter<String, Long> {

        @Override
        public Long convertToDatabaseColumn(String attribute) {
            return Long.parseLong(attribute);
        }

        @Override
        public String convertToEntityAttribute(Long dbData) {
            return dbData.toString();
        }
    }
}
