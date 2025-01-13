package com.aitorortegadev.auth_service.service;

import com.aitorortegadev.auth_service.common.dtos.TokenResponse;
import io.jsonwebtoken.Claims;

public interface JwtService {

  TokenResponse generateToken(Long userId);

  Claims getClaimsFromToken(String token);

  boolean isTokenExpired(String token);

  Integer getUserIdFromToken(String token);
}
