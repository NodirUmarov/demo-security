package com.security.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDateTime;
import org.hibernate.validator.constraints.Length;

public record UserDto(Long id,
                      @Email(message = "Username should be email") String username,
                      @Length(min = 8, max = 16, message = "Password should contain minimum 8 and maximum 16 characters") String password,
                      String firstName,
                      String lastName,
                      @Past LocalDateTime dob,
                      @JsonIgnore LocalDateTime createdDate,
                      @JsonIgnore LocalDateTime lastModifiedDate) implements Serializable {

}