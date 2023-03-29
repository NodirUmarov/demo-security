package com.security.demo.controller;

import com.security.demo.controller.config.ApiPath;
import com.security.demo.model.dto.AuthorityDto;
import com.security.demo.service.AuthorityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.AUTHORITY_PATH)
@RequiredArgsConstructor
public class AuthorityController {

    private final AuthorityService authorityService;

    @GetMapping
    public List<AuthorityDto> getAll() {
        return authorityService.getAll();
    }

}