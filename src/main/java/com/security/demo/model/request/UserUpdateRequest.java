package com.security.demo.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserUpdateRequest {

    @Positive
    @NotNull
    private Long id;

    @Email
    @NotNull
    private String username;

    @Length(min = 8, max = 16)
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Past
    @NotNull
    private LocalDate dob;

    @Positive
    @NotNull
    private Long roleId;
}
