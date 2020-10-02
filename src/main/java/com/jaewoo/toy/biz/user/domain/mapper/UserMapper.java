package com.jaewoo.toy.biz.user.domain.mapper;

import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntityForCreate(UserDto.CreateRequest createRequest);
    void toEntityForUpdate(UserDto.UpdateRequest updateRequest, @MappingTarget User user);
    UserDto.UserResponse toUserResponse(User user);
}