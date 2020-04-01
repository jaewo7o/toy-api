package com.jaewoo.toy.biz.user.repository;

import com.jaewoo.toy.biz.user.entity.User;
import com.jaewoo.toy.biz.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoistory {

    private List<User> users;

    @Autowired
    private JwtUtil jwtUtil;

    UserRepoistory() {
        users = new ArrayList<>();
        users.add(new User(1L, "Jaewoo", "jaewo7o@naver.com", "1234", jwtUtil.createToken()));
        users.add(new User(2L, "Channel", "chanel0901@naver.com", "1234", jwtUtil.createToken()));
    }


    public Optional<User> getUserByLoginId(String loginId) {
        Optional<User> selectUser = Optional.empty();

        for (User user : users) {
            if (user.getLoginId().equals(loginId)) {
                selectUser = Optional.of(user);
                break;
            }
        }

        return selectUser;
    }
}
