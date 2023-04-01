package com.security.demo.service;

import com.security.demo.model.dto.PermissionDto;
import java.util.List;

public interface PermissionService {
    List<PermissionDto> getAll();
}