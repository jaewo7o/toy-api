package com.jaewoo.toy.common.config.interceptor;

import com.google.common.base.Preconditions;
import com.jaewoo.toy.biz.user.entity.User;
import com.jaewoo.toy.biz.user.service.UserService;
import com.jaewoo.toy.common.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    private final String HEADER_AUTH = "access-token";

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    public boolean preHandler(HttpServletRequest request, HttpServletResponse response) {
        String loginId = request.getHeader("loginId");
        User user = userService.findByLoginId(loginId).get();

        String token = request.getHeader(HEADER_AUTH);
        if (jwtService.isUsable(token)) {
            return true;
        } else {
            return false;
        }
    }
}
