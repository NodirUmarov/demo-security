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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('MODERATOR_READ')")
    public UserDto getOne(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @GetMapping(params = {"roleName"})
    @PreAuthorize("hasAuthority('MODERATOR_READ')")
    public List<UserDto> getAllByRole(@RequestParam String roleName,
                                      @RequestParam(defaultValue = "0") @Validated @PositiveOrZero Integer pageNumber,
                                      @RequestParam(defaultValue = "10") @Validated @Length(min = 1, max = 25) Integer pageSize) {
        return userService.getAllByRole(roleName, pageNumber, pageSize);
    }

    @GetMapping(params = {"size"})
    @PreAuthorize("hasAuthority('USER_READ')")
    public Integer getPageCount(@RequestParam Integer size) {
        return userService.getPageCount(size);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('MODERATOR_READ')")
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

    @GetMapping
    @PreAuthorize("hasAuthority('USER_READ')")
    public UserDto getMe(Authentication authentication) {
        return userService.getOneByUsername(authentication.getName());
    }

}