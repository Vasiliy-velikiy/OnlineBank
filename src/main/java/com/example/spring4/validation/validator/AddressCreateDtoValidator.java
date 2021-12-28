package com.example.spring4.validation.validator;

import com.example.spring4.domain.dto.address.AddressCreateDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author dkotov
 * @since 23.12.2021
 */
@Component
public class AddressCreateDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(AddressCreateDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final AddressCreateDto addressCreateDto = (AddressCreateDto) target;
        if (addressCreateDto.getCity() == null) {
            errors.rejectValue("city", "City is required");
        }
    }
}
