package com.aitorortegadev.auth_service.controller.impl;

import com.aitorortegadev.auth_service.common.dtos.TokenResponse;
import com.aitorortegadev.auth_service.common.dtos.UserRequest;
import com.aitorortegadev.auth_service.controller.AuthApi;
import com.aitorortegadev.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @Override
  public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
    return ResponseEntity.ok(authService.createUser(userRequest));
  }
}
