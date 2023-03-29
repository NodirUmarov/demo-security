package com.security.demo.repository;

import com.security.demo.model.entity.User;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAllByRoleNameIgnoreCaseAndIsEnabledTrue(String name, Pageable pageable);
    Boolean existsByUsernameAndIsEnabledTrue(String username); // SELECT EXISTS(SELECT * FROM tb_users WHERE username = ?);

    @Query(value = "SELECT CEILING(COUNT(*) / :size) FROM tb_users WHERE is_enabled IS TRUE", nativeQuery = true)
    Integer countPages(@Param("size") Double size);

    Optional<User> findByUsername(String username);

    // TODO: 3/18/2023 Find only username
}