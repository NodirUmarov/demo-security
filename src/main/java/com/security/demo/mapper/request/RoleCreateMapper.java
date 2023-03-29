package com.security.demo.mapper.request;

import com.security.demo.mapper.config.EntityMapper;
import com.security.demo.mapper.config.MapstructAutoWire;
import com.security.demo.model.entity.Role;
import com.security.demo.model.request.RoleCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructAutoWire.class)
public interface RoleCreateMapper extends EntityMapper<Role, RoleCreateRequest> {

    @Override
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    Role toEntity(RoleCreateRequest dto);
}