package com.security.demo.service.impl;

import com.security.demo.mapper.dto.AuthorityMapper;
import com.security.demo.model.dto.AuthorityDto;
import com.security.demo.model.entity.Authority;
import com.security.demo.repository.AuthorityRepository;
import com.security.demo.service.AuthorityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final AuthorityMapper authorityMapper;

    @Override
    public List<AuthorityDto> getAll() {
        log.info("Getting all authorities...");
        List<Authority> authorities = authorityRepository.findAll();
        return authorityMapper.toDtoList(authorities);
    }
}
