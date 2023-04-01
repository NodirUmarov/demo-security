package com.security.demo.mapper.dto;

import com.security.demo.mapper.config.DtoMapper;
import com.security.demo.mapper.config.MapstructAutoWire;
import com.security.demo.model.dto.PermissionDto;
import com.security.demo.model.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(config = MapstructAutoWire.class)
public interface PermissionMapper extends DtoMapper<PermissionDto, Permission> {
}