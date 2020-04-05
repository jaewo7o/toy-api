package com.jaewoo.toy.biz.user.service;

import com.jaewoo.toy.admin.feature.login.dto.UserDto;
import com.jaewoo.toy.biz.user.entity.User;
import com.jaewoo.toy.biz.user.repository.UserRepoistory;
import com.jaewoo.toy.common.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepoistory userRepoistory;

    @Autowired
    JwtService jwtService;

    public UserDto.LoginResponse login(UserDto.LoginRequest request) {
        User findUser = userRepoistory.getUserByLoginId(request.getLoginId()).orElseThrow(() -> new NoSuchElementException());

        if (!findUser.getPassword().equals(request.getPassword())) {
            throw new NoSuchElementException("Password 불일치");
        }

        String token = jwtService.create(findUser.getLoginId(), findUser, "user");

        return new UserDto.LoginResponse(token);
    }

    public Optional<User> findByLoginId(String loginId) {
        return userRepoistory.getUserByLoginId(loginId);
    }
}
