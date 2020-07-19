package com.jaewoo.toy.biz.user.domain;

import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto.CreateRequest createRequest);


    UserDto.UserResponse toUserResponse(User user);
}