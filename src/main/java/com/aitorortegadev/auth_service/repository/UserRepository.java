package com.aitorortegadev.auth_service.repository;

import com.aitorortegadev.auth_service.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
