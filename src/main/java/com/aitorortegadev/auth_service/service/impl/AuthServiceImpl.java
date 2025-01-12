package com.aitorortegadev.auth_service.service.impl;

import com.aitorortegadev.auth_service.common.dtos.TokenResponse;
import com.aitorortegadev.auth_service.common.dtos.UserRequest;
import com.aitorortegadev.auth_service.common.mappers.UserMapper;
import com.aitorortegadev.auth_service.repository.UserRepository;
import com.aitorortegadev.auth_service.service.AuthService;
import com.aitorortegadev.auth_service.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final UserMapper userMapper;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.userMapper = userMapper;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(userMapper::toEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }
}
