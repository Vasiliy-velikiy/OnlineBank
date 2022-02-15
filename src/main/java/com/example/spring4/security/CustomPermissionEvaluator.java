package com.example.spring4.security;

import com.example.spring4.domain.dto.UserDto;
import com.example.spring4.repository.BillingDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * @author dkotov
 * @since 15.02.2022
 */
@Component
@Transactional
@RequiredArgsConstructor
public class CustomPermissionEvaluator implements PermissionEvaluator {
    private final BillingDetailsRepository billingDetailsRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        UserDto userDto = (UserDto) authentication.getPrincipal();
        if (Objects.equals(targetType, "BillingDetails") && permission.equals("UPDATE")) {
            return billingDetailsRepository.existsByUserIdAndId((UUID) targetId, userDto.getId());
        }
        return false;
    }
}
