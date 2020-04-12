package com.jaewoo.toy.biz.user.entity;

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
    public static class LoginResponse {
        private String token;
        public LoginResponse(String token) {
            this.token = token;
        }
    }

    @Getter
    @Setter
    public static class UserResponse {
        private String id;
        private String name;
        private String loginId;
    }
}
