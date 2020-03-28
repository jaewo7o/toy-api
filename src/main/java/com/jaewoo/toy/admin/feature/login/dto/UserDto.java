package com.jaewoo.toy.admin.feature.login.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class UserDto {
    @Getter
    @Setter
    public static class LoginRequest {
        @NotNull
        private String loginId;
        @NotNull
        private String password;
    }
}
