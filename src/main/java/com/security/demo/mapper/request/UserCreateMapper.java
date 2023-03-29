package com.security.demo.mapper.request;

import com.security.demo.mapper.config.EntityMapper;
import com.security.demo.mapper.config.MapstructAutoWire;
import com.security.demo.model.entity.User;
import com.security.demo.model.request.UserCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructAutoWire.class)
public interface UserCreateMapper extends EntityMapper<User, UserCreateRequest> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "isEnabled", ignore = true)
    User toEntity(UserCreateRequest request);
}