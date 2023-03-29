package com.security.demo.controller;

import com.security.demo.model.dto.UserDto;
import com.security.demo.model.request.UserCreateRequest;
import com.security.demo.model.request.UserUpdateRequest;
import com.security.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    // TODO: 3/14/2023 .env file implement
    // TODO: 3/19/2023 UPDATE(PATCH, PUT) and DELETE
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }

    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @GetMapping(params = {"roleName"})
    public List<UserDto> getAllByRole(@RequestParam String roleName,
                                      @RequestParam(defaultValue = "0") @Validated @PositiveOrZero Integer pageNumber,
                                      @RequestParam(defaultValue = "10") @Validated @Length(min = 1, max = 25) Integer pageSize) {
        return userService.getAllByRole(roleName, pageNumber, pageSize);
    }

    @GetMapping
    public Integer getPageCount(@RequestParam(defaultValue = "10") Integer size) {
        return userService.getPageCount(size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateOne(@RequestBody UserUpdateRequest request,
                                              @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateOne(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.deleteOne(id));
    }

    @DeleteMapping(params = {"username"})
    public ResponseEntity<UserDto> deleteOne(@RequestParam String username) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.deleteOne(username));
    }

    @DeleteMapping("/{id}/admin")
    public ResponseEntity<UserDto> entirelyDelete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.entirelyDelete(id));
    }
}