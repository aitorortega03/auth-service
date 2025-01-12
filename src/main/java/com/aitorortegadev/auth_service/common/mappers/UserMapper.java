package com.aitorortegadev.auth_service.common.mappers;

import com.aitorortegadev.auth_service.common.dtos.UserRequest;
import com.aitorortegadev.auth_service.common.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role", constant = "USER")
    User toEntity(UserRequest userRequest);
}
