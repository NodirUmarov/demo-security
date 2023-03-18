package com.security.demo.service;

import com.security.demo.model.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto create(UserDto userDto);
    UserDto getOne(Long id);

    List<UserDto> getAllByRole(String roleName);
}
