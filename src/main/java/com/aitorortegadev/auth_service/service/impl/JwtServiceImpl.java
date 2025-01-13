package com.aitorortegadev.auth_service.service.impl;

import com.aitorortegadev.auth_service.common.dtos.TokenResponse;
import com.aitorortegadev.auth_service.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

  private final Key key;

  public JwtServiceImpl(@Value("${jwt.secret}") String secretToken) {
    this.key = Keys.hmacShaKeyFor(secretToken.getBytes(StandardCharsets.UTF_8));
  }

  @Override
  public TokenResponse generateToken(Long userId) {
    Date expirationDate = new Date(Long.MAX_VALUE);

    String token = Jwts.builder()
      .subject(String.valueOf(userId))
      .issuedAt(new Date(Instant.now().toEpochMilli()))
      .expiration(expirationDate)
      .signWith(this.key)
      .compact();
    return TokenResponse.builder()
      .token(token)
      .build();
  }

  @Override
  public Claims getClaimsFromToken(String token) {
    return Jwts.parser()
      .verifyWith((SecretKey) this.key)
      .build()
      .parseSignedClaims(token)
      .getPayload();
  }

  @Override
  public boolean isTokenExpired(String token) {
    try {
      return getClaimsFromToken(token).getExpiration().before(new Date());
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public Integer getUserIdFromToken(String token) {
    try {
      return Integer.parseInt(getClaimsFromToken(token).getSubject());
    } catch (Exception e) {
      return null;
    }
  }
}
