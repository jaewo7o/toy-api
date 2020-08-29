package com.jaewoo.toy.biz.user.service;

import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUserId() {
        // 1. given
        Long id = Long.valueOf(1l);

        // 2. when
        final User user = userService.findById(id);
    }

    @Test
    void findById() {
        userService.findById(1L);
    }

    @Test
    void save() {
        UserDto.CreateRequest createRequest = new UserDto.CreateRequest();
        createRequest.setLastName("JUNG");
        createRequest.setFirstName("JAEWOO");
        createRequest.setName("J.J.W");

        userService.save(createRequest);
    }

    @Test
    void updateUser() throws Exception {
        UserDto.UpdateRequest updateRequest = new UserDto.UpdateRequest();
        updateRequest.setId(1L);
        updateRequest.setEmailAddress("jeawoo.jeong5@mail.com");

        userService.updateUser(updateRequest);
    }
}