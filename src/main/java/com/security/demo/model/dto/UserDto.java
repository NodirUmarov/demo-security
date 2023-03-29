package com.security.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.demo.model.entity.Role;
import jakarta.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDto(Long id,
                      String username,
                      String password,
                      String firstName,
                      String lastName,
                      LocalDate dob,
                      Role role,
                      @JsonIgnore Boolean isEnabled,
                      @JsonIgnore LocalDateTime createdDate,
                      @JsonIgnore LocalDateTime lastModifiedDate) implements Serializable {

}