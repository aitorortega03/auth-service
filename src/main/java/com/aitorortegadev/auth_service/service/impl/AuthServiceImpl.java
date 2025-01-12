package com.aitorortegadev.auth_service.service.impl;

import com.aitorortegadev.auth_service.common.dtos.TokenResponse;
import com.aitorortegadev.auth_service.common.dtos.UserRequest;
import com.aitorortegadev.auth_service.common.entities.User;
import com.aitorortegadev.auth_service.repository.UserRepository;
import com.aitorortegadev.auth_service.service.AuthService;
import com.aitorortegadev.auth_service.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    private User mapToEntity(UserRequest userRequest) {
        return User.builder()
          .username(userRequest.getUsername())
          .email(userRequest.getEmail())
          .password(userRequest.getPassword())
          .role("USER")
          .build();
    }
}
