package com.jaewoo.toy.biz.user.repository;

import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int updateUser(UserDto.UpdateRequest user);
}
