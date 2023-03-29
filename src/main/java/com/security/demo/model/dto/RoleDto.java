package com.security.demo.model.dto;

import com.security.demo.model.entity.Role;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link Role} entity
 */
public record RoleDto(Long id,
                      String name,
                      List<AuthorityDto> authorities,
                      LocalDateTime createdDate,
                      LocalDateTime lastModifiedDate) implements Serializable {
}