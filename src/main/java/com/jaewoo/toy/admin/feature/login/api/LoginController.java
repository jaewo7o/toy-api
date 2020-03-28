package com.jaewoo.toy.admin.feature.login.api;

import com.jaewoo.toy.admin.feature.login.dto.UserDto;
import com.jaewoo.toy.biz.user.entity.User;
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
@RequestMapping(SystemConst.API_URL + "/login")
public class LoginController {

    @Autowired
    UserService userService;

    @ApiOperation(
            httpMethod = "POST",
            value = "사용자 로그인",
            notes = "ID/PW를 받고 사용자 로그인 처리를 해준다."
    )
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody @Valid UserDto.LoginRequest request) {
        User user = userService.checkLoginAuthentication(request);
        return ResponseEntity.ok(user);
    }
}
