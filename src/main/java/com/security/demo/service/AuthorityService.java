package com.security.demo.service;

import com.security.demo.model.dto.AuthorityDto;
import java.util.List;

public interface AuthorityService {
    List<AuthorityDto> getAll();
}