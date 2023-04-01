package com.security.demo.mapper.dto;

import com.security.demo.mapper.config.DtoMapper;
import com.security.demo.mapper.config.EntityMapper;
import com.security.demo.mapper.config.MapstructAutoWire;
import com.security.demo.model.dto.UserDto;
import com.security.demo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructAutoWire.class)
public interface UserMapper extends DtoMapper<UserDto, User>, EntityMapper<User, UserDto> {

    @Override
    @Mapping(target = "authorities", ignore = true)
    User toEntity(UserDto dto);
}