package com.jaewoo.toy.biz.user.domain.dto;

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
    public static class CreateRequest {
        @NotNull
        private String loginId;
        @NotNull
        private String password;

        private String name;

        private String firstName;

        private String lastName;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class LoginResponse {
        private String token;
        private long id;
    }

    @Getter
    @Setter
    public static class UserResponse {
        private String id;
        private String name;
        private String loginId;
    }
}
