package com.security.demo.repository;

import com.security.demo.model.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByRolesNameIgnoreCase(String name);

    // TODO: 3/18/2023 Find only username
}