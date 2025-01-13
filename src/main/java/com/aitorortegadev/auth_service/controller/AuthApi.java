package com.aitorortegadev.auth_service.controller;

import com.aitorortegadev.auth_service.common.dtos.TokenResponse;
import com.aitorortegadev.auth_service.common.dtos.UserLoginRequest;
import com.aitorortegadev.auth_service.common.dtos.UserRequest;
import com.aitorortegadev.auth_service.constants.ApiPathConstants;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface AuthApi {

  @PostMapping(ApiPathConstants.REGISTER_ROUTE)
  ResponseEntity<TokenResponse> createUser(@RequestBody @Valid UserRequest userRequest);

  @PostMapping(ApiPathConstants.LOGIN_ROUTE)
  ResponseEntity<TokenResponse> login(@RequestBody @Valid UserLoginRequest userLoginRequest);
}
