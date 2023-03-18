package com.security.demo.controller;

import com.security.demo.model.dto.UserDto;
import com.security.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    // TODO: 3/14/2023 Validation
    // TODO: 3/14/2023 Requests and Responses
    // TODO: 3/14/2023 .env file implement
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDto));
    }

    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @GetMapping
    public List<UserDto> getAllByRole(@RequestParam String roleName) {
        return userService.getAllByRole(roleName);
    }
}