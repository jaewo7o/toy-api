package com.jaewoo.toy.biz.user.service;

import com.jaewoo.toy.biz.user.domain.entity.User;
import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.repository.UserRepository;
import com.jaewoo.toy.common.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    public UserDto.LoginResponse login(UserDto.LoginRequest request) {
        User findUser = userRepository.findByLoginId(request.getLoginId()).orElseThrow(() -> new NoSuchElementException());

        if (!findUser.getPassword().equals(request.getPassword())) {
            throw new NoSuchElementException("Password 불일치");
        }

        String token = jwtService.create(findUser.getLoginId(), findUser, "user");

        return new UserDto.LoginResponse(token, findUser.getId());
    }

    public Optional<User> findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
