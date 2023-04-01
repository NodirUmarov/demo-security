package com.security.demo.service;

import com.security.demo.model.dto.UserDto;
import com.security.demo.model.request.UserCreateRequest;
import com.security.demo.model.request.UserUpdateRequest;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto create(UserCreateRequest request);
    UserDto getOne(Long id);

    List<UserDto> getAllByRole(String roleName, Integer pageNumber, Integer pageSize);

    Integer getPageCount(Integer size);

    UserDto updateOne(UserUpdateRequest request, Long id);

    UserDto deleteOne(Long id);
    UserDto deleteOne(String username);

    UserDto entirelyDelete(Long id);

    UserDto getOneByUsername(String name);
}