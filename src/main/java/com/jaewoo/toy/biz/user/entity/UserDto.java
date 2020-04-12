package com.jaewoo.toy.biz.user.entity;

import lombok.AllArgsConstructor;
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

    @Getter
    @Setter
    @AllArgsConstructor
    public static class LoginResponse {
        private String token;
        private String userId;
    }

    @Getter
    @Setter
    public static class UserResponse {
        private String id;
        private String name;
        private String loginId;
    }
}
