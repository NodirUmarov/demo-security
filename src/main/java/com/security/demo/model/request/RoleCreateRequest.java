package com.security.demo.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Data;

@Data
public class RoleCreateRequest {

    @NotBlank
    private String name;

    @NotEmpty
    List<Long> authoritiesIds;
}