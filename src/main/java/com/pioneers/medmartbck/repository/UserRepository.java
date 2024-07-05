package com.pioneers.medmartbck.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pioneers.medmartbck.model.User;

public interface UserRepository extends JpaRepository <User, Long>{
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String email, String username);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
