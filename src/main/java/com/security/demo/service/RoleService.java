package com.security.demo.service;

import com.security.demo.model.dto.RoleDto;
import com.security.demo.model.request.RoleCreateRequest;

public interface RoleService {

    RoleDto create(RoleCreateRequest request);

}
