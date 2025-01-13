package com.aitorortegadev.auth_service.common.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {

  @NonNull
  private String username;

  @NonNull
  private String password;
}
