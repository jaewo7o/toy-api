package com.jaewoo.toy.biz.user.service;

import com.jaewoo.toy.biz.user.entity.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUserId() {
        // 1. given
        String userId = "1";

        // 2. when
        final UserDto.UserResponse user = userService.findByUserId(userId);

        // 3. decision
        Assert.assertEquals(userId, user.getId());
    }
}