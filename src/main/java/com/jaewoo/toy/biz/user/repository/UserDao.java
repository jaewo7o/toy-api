package com.jaewoo.toy.biz.user.repository;

import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int updateUser(UserDto.UpdateRequest user);
}
