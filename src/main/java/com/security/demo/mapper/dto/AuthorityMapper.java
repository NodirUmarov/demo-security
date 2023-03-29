package com.security.demo.mapper.dto;

import com.security.demo.mapper.config.DtoMapper;
import com.security.demo.mapper.config.MapstructAutoWire;
import com.security.demo.model.dto.AuthorityDto;
import com.security.demo.model.entity.Authority;
import org.mapstruct.Mapper;

@Mapper(config = MapstructAutoWire.class)
public interface AuthorityMapper extends DtoMapper<AuthorityDto, Authority> {
}