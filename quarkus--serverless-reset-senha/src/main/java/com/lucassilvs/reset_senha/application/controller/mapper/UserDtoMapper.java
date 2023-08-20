package com.lucassilvs.reset_senha.application.controller.mapper;

import com.lucassilvs.reset_senha.application.controller.dto.UserDto;
import com.lucassilvs.reset_senha.domain.models.UserModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);


    UserDto map(UserModel userModel);

    @InheritInverseConfiguration
    UserModel map(UserDto userDto);
}
