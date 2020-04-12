package com.jaewoo.toy.biz.user.entity;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto.UserResponse toUserResponse(User user) {
        UserDto.UserResponse target = new UserDto.UserResponse();
        target.setId(user.getId().toString());
        target.setLoginId(user.getLoginId());
        target.setName(user.getName());
        return target;
    }
}
