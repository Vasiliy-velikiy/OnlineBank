package com.example.spring4.validation.validator;

import com.example.spring4.domain.dto.UserCreateDto;
import com.example.spring4.domain.dto.address.AddressCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author dkotov
 * @since 23.12.2021
 */
@Component
@RequiredArgsConstructor
public class UserCreateDtoValidator implements Validator {
    private final AddressCreateDtoValidator addressCreateDtoValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(UserCreateDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final UserCreateDto userCreateDto = (UserCreateDto) target;
        if (userCreateDto.getEmail() == null) {
            errors.rejectValue("email", "email.notValid");
        }
        AddressCreateDto addressCreateDto = userCreateDto.getAddress();
        if (addressCreateDto != null) {
            if (addressCreateDto.getCity() == null) {
                errors.rejectValue("address.city", "Address is required");
            }
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(addressCreateDtoValidator, addressCreateDto, errors);
            errors.popNestedPath();
        }
    }
}
