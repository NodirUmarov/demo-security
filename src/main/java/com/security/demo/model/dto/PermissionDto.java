package com.security.demo.model.dto;

import com.security.demo.model.entity.Permission;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Permission} entity
 */
public record PermissionDto(Long id,
                            String authority,
                            LocalDateTime createdDate,
                            LocalDateTime lastModifiedDate) implements Serializable {
}