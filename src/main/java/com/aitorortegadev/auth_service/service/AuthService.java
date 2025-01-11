package com.aitorortegadev.auth_service.service;

import com.aitorortegadev.auth_service.common.dtos.TokenResponse;
import com.aitorortegadev.auth_service.common.dtos.UserRequest;

public interface AuthService {

    TokenResponse createUser(UserRequest userRequest);
}
