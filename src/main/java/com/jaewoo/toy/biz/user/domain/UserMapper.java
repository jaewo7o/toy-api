package com.jaewoo.toy.biz.user.domain;

import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto.CreateRequest createRequest);
    void toEntity2(UserDto.UpdateRequest updateRequest, @MappingTarget User user);
    UserDto.UserResponse toUserResponse(User user);
}