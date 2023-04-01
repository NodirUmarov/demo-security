package com.security.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@Table(name = "tb_permissions")
@NoArgsConstructor
public class Permission extends BaseEntity implements GrantedAuthority {

    @Column(nullable = false, unique = true)
    private String authority;

}