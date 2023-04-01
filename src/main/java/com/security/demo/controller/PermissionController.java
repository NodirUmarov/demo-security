package com.security.demo.controller;

import com.security.demo.controller.config.ApiPath;
import com.security.demo.model.dto.PermissionDto;
import com.security.demo.service.PermissionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.AUTHORITY_PATH)
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    public List<PermissionDto> getAll() {
        return permissionService.getAll();
    }

}