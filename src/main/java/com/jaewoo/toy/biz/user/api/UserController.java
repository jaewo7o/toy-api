package com.jaewoo.toy.biz.user.api;

import com.jaewoo.toy.biz.user.domain.entity.User;
import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import com.jaewoo.toy.biz.user.domain.UserMapper;
import com.jaewoo.toy.biz.user.service.UserService;
import com.jaewoo.toy.common.consts.SystemConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(value = "login")
@RestController
@RequestMapping(SystemConst.API_URL + "/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper mapper;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @ApiOperation(
            httpMethod = "GET",
            value = "사용자 정보조회",
            notes = "현재 사용자 정보를 조회한다."
    )
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserDto.UserResponse> getUser(@PathVariable @ApiParam(required = true) Long id) {
        User findUser = userService.findById(id);
        return ResponseEntity.ok().body(mapper.toUserResponse(findUser));
    }

    @PostMapping("")
    public User createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }
}
