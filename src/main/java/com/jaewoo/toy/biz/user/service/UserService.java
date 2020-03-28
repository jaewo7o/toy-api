package com.jaewoo.toy.biz.user.service;

import com.jaewoo.toy.admin.feature.login.dto.UserDto;
import com.jaewoo.toy.biz.user.entity.User;
import com.jaewoo.toy.biz.user.repository.UserRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    UserRepoistory userRepoistory;

    public User checkLoginAuthentication(UserDto.LoginRequest request) {
        return userRepoistory.getUser(request.getLoginId(), request.getPassword()).orElseThrow(() -> new NoSuchElementException());
    }
}
