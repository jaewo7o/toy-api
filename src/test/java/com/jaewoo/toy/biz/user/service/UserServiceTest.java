package com.jaewoo.toy.biz.user.service;

import com.jaewoo.toy.biz.user.domain.entity.User;
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
        Long id = Long.valueOf(1l);

        // 2. when
        final User user = userService.findById(id);

        // 3. decision
        Assert.assertEquals(id, user.getId());
    }
}