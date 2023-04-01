package com.security.demo.service.impl;

import com.security.demo.mapper.dto.RoleMapper;
import com.security.demo.mapper.request.RoleCreateMapper;
import com.security.demo.model.dto.RoleDto;
import com.security.demo.model.entity.Permission;
import com.security.demo.model.entity.Role;
import com.security.demo.model.request.RoleCreateRequest;
import com.security.demo.repository.PermissionRepository;
import com.security.demo.repository.RoleRepository;
import com.security.demo.service.RoleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final RoleCreateMapper roleCreateMapper;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto create(RoleCreateRequest request) {
        log.info("Role creating...");
        List<Permission> authorities = permissionRepository.findAllById(request.getAuthoritiesIds());

        Role role = roleCreateMapper.toEntity(request);
        role.setAuthorities(authorities);

        roleRepository.save(role);

        return roleMapper.toDto(role);
    }
}
