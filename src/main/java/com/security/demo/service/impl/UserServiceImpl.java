package com.security.demo.service.impl;

import com.security.demo.exception.NoContentToShowException;
import com.security.demo.exception.UserIsNotEnabledException;
import com.security.demo.mapper.dto.UserMapper;
import com.security.demo.mapper.request.UserCreateMapper;
import com.security.demo.mapper.request.UserUpdateMapper;
import com.security.demo.model.dto.UserDto;
import com.security.demo.model.entity.Role;
import com.security.demo.model.entity.User;
import com.security.demo.model.request.UserCreateRequest;
import com.security.demo.model.request.UserUpdateRequest;
import com.security.demo.repository.RoleRepository;
import com.security.demo.repository.UserRepository;
import com.security.demo.service.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserUpdateMapper userUpdateMapper;

    @Override
    public UserDto create(UserCreateRequest request) {
        log.info("Creating user...");

        if (userRepository.existsByUsernameAndIsEnabledTrue(request.getUsername())) {
            throw new EntityExistsException("User with username=" + request.getUsername() + " already exists");
        }

        if (request.getDob() == null) {
            log.warn("Date of birth is empty, no any sales will be available");
        }

        User user = userCreateMapper.toEntity(request);
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role with id=" + request.getRoleId() + " not found"));
        user.setRole(role);
        userRepository.save(user);

        log.info("User created");
        return userMapper.toDto(user);
    }

    @Override
    public UserDto getOne(Long id) {
        log.info("Searching for user with id={}", id);
        return userMapper.toDto(userRepository.findById(id).map(u -> {
                    if (!u.getIsEnabled()) {
                        throw new UserIsNotEnabledException();
                    }
                    return u;
                })
                .orElseThrow(() -> new EntityNotFoundException("User by id=" + id + " not found")));
    }

    @Override
    public List<UserDto> getAllByRole(String roleName, Integer pageNumber, Integer pageSize) {
        log.info("Searching for users with role='{}'", roleName);

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<User> page = userRepository.findAllByRoleNameIgnoreCaseAndIsEnabledTrue(roleName, pageable);

        return userMapper.toDtoList(page.toList());
    }

    @Override
    public Integer getPageCount(Integer size) {
        log.info("Counting pages by given size per page: {}", size);

        Integer pages = userRepository.countPages(size.doubleValue());
        if (pages == 0) {
            throw new NoContentToShowException("No users to show yet");
        }

        return pages;
    }

    @Override
    public UserDto updateOne(UserUpdateRequest request, Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User by id=" + id + " not found");
        }

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role by id=" + id + " not found"));

        User user = userUpdateMapper.toEntity(request);
        user.setRole(role);

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto deleteOne(Long id) {
        return userMapper.toDto(userRepository.findById(id).map(u -> {
            if (!u.getIsEnabled()) {
                throw new UserIsNotEnabledException();
            }
            u.setIsEnabled(false);
            return userRepository.save(u);
        }).orElseThrow(() -> new EntityNotFoundException("User by id=" + id + " not found")));
    }

    @Override
    public UserDto deleteOne(String username) {
        return userMapper.toDto(userRepository.findByUsername(username).map(u -> {
            if (!u.getIsEnabled()) {
                throw new UserIsNotEnabledException();
            }
            u.setIsEnabled(false);
            return userRepository.save(u);
        }).orElseThrow(() -> new EntityNotFoundException("User by username='" + username + "' not found")));
    }

    @Override
    public UserDto entirelyDelete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User by id=" + id + " not found"));
        userRepository.deleteById(id);
        return userMapper.toDto(user);
    }
}