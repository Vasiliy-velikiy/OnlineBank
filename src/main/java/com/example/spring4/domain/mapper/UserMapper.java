package com.example.spring4.domain.mapper;

import com.example.spring4.domain.dto.UserCreateDto;
import com.example.spring4.domain.dto.UserDto;
import com.example.spring4.domain.dto.UserInfoDto;
import com.example.spring4.domain.dto.UserUpdateDto;
import com.example.spring4.domain.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * @author dkotov
 * @since 16.12.2021
 */
@Mapper
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "addressEmbeddable", ignore = true)
    User fromCreateDto(UserCreateDto source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "addressEmbeddable", ignore = true)
    User fromUpdateDto(UserUpdateDto source);

    @Mapping(target = "age", ignore = true)
    UserDto toDto(User source);

    @Mapping(target = "addressId", source = "address.id")
    UserInfoDto toInfoDto(User source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    User merge(@MappingTarget User target, User source);
}
