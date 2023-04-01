package com.security.demo.service.impl;

import com.security.demo.mapper.dto.PermissionMapper;
import com.security.demo.model.dto.PermissionDto;
import com.security.demo.model.entity.Permission;
import com.security.demo.repository.PermissionRepository;
import com.security.demo.service.PermissionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public List<PermissionDto> getAll() {
        log.info("Getting all authorities...");
        List<Permission> authorities = permissionRepository.findAll();
        return permissionMapper.toDtoList(authorities);
    }
}
