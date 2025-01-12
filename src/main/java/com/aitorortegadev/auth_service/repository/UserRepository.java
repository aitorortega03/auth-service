package com.aitorortegadev.auth_service.repository;

import com.aitorortegadev.auth_service.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
