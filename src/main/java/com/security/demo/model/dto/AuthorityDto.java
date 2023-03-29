package com.security.demo.model.dto;

import com.security.demo.model.entity.Authority;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Authority} entity
 */
public record AuthorityDto(Long id,
                           String permission,
                           LocalDateTime createdDate,
                           LocalDateTime lastModifiedDate) implements Serializable {
}