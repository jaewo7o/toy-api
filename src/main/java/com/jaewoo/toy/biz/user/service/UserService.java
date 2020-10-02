package com.jaewoo.toy.biz.user.service;

import com.jaewoo.toy.biz.user.domain.mapper.UserMapper;
import com.jaewoo.toy.biz.user.domain.entity.User;
import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.repository.UserDao;
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
    UserMapper userMapper;

    @Autowired
    JwtService jwtService;

    @Autowired
    UserDao userDao;

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
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User createUser(UserDto.CreateRequest createRequest) {
        User user = userMapper.toEntityForCreate(createRequest);
        return userRepository.save(user);
    }


    public void updateUser(UserDto.UpdateRequest updateRequest) throws Exception {
        User user = userRepository.findById(updateRequest.getId()).orElseThrow(() -> new NoSuchElementException());
        userMapper.toEntityForUpdate(updateRequest, user);

        userRepository.save(user);
    }
}
