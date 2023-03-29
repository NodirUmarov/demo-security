package com.security.demo.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserCreateRequest {

    @Email(message = "Username should be email")
    private String username;

    @Length(min = 8, max = 16)
    private String password;

    private String firstName;
    private String lastName;

    @Past
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dob;

    @Positive
    private Long roleId;
}