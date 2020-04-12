package com.jaewoo.toy.biz.user.api;

import com.jaewoo.toy.biz.user.entity.UserDto;
import com.jaewoo.toy.biz.user.service.UserService;
import com.jaewoo.toy.common.consts.SystemConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api(value = "login")
@RestController
@RequestMapping(SystemConst.API_URL + "/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(
            httpMethod = "POST",
            value = "사용자 정보조회",
            notes = "현재 사용자 정보를 조회한다."
    )
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserDto.LoginResponse> login(@RequestBody @Valid UserDto.LoginRequest request) {
        UserDto.LoginResponse user = userService.login(request);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserDto.UserResponse> getUser(@PathVariable String userId) {
        UserDto.UserResponse user = userService.findByUserId(userId);
        return ResponseEntity.ok(user);
    }
}
