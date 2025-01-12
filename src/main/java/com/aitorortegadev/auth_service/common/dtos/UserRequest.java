package com.aitorortegadev.auth_service.common.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;
}
