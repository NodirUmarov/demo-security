package com.security.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Authority extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true)
    private String permission;

}