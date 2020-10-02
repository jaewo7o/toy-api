package com.jaewoo.toy.biz.user.service;

import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.domain.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUserId() {
        // given
        Long id = Long.valueOf(1l);

        // when
        final User user = userService.findById(id);
    }

    @Test
    void findById() {
        userService.findById(1L);
    }

    @Test
    void createUser() {
        // given
        UserDto.CreateRequest createRequest = new UserDto.CreateRequest();
        createRequest.setLastName("JUNG");
        createRequest.setFirstName("JAEWOO");
        createRequest.setName("J.J.W");

        // when
        User user = userService.createUser(createRequest);

        // then
        Assertions.assertThat(user.getId()).isNotNull();
        Assertions.assertThat(user.getName()).isEqualTo(createRequest.getName());
    }

    @Test
    void updateUser() throws Exception {
        UserDto.UpdateRequest updateRequest = new UserDto.UpdateRequest();
        updateRequest.setId(1L);
        updateRequest.setEmailAddress("jeawoo.jeong5@mail.com");

        userService.updateUser(updateRequest);
    }
}