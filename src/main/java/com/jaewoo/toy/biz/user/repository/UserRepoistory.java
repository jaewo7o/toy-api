package com.jaewoo.toy.biz.user.repository;

import com.jaewoo.toy.biz.user.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoistory {

    private List<User> users;

    @PostConstruct
    private void initialSetting() {
        users = new ArrayList<>();
        users.add(new User(1L, "Jaewoo", "jaewo7o@naver.com", "1234"));
        users.add(new User(2L, "Channel", "chanel0901@naver.com", "1234"));
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
