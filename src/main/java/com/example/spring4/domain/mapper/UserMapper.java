package com.example.spring4.domain.mapper;

import com.example.spring4.domain.dto.UserCreateDto;
import com.example.spring4.domain.dto.UserDto;
import com.example.spring4.domain.dto.UserUpdateDto;
import com.example.spring4.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author dkotov
 * @since 16.12.2021
 */
@Mapper
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User fromCreateDto(UserCreateDto source);

    @Mapping(target = "id", ignore = true)
    User fromUpdateDto(UserUpdateDto source);

    UserDto toDto(User source);
}
