package com.security.demo.mapper.request;

import com.security.demo.mapper.config.EntityMapper;
import com.security.demo.mapper.config.MapstructAutoWire;
import com.security.demo.model.entity.User;
import com.security.demo.model.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructAutoWire.class)
public interface UserUpdateMapper extends EntityMapper<User, UserUpdateRequest> {

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isEnabled", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User toEntity(UserUpdateRequest dto);
}