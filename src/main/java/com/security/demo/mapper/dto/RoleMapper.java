package com.security.demo.mapper.dto;

import com.security.demo.mapper.config.DtoMapper;
import com.security.demo.mapper.config.MapstructAutoWire;
import com.security.demo.model.dto.RoleDto;
import com.security.demo.model.entity.Role;
import org.mapstruct.Mapper;

@Mapper(config = MapstructAutoWire.class, uses = {AuthorityMapper.class})
public interface RoleMapper extends DtoMapper<RoleDto, Role> {
}