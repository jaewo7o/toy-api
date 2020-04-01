package com.jaewoo.toy.common.config.interceptor;

import com.google.common.base.Preconditions;
import com.jaewoo.toy.biz.user.entity.User;
import com.jaewoo.toy.biz.user.service.UserService;
import com.jaewoo.toy.biz.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    public boolean preHandler(HttpServletRequest request, HttpServletResponse response) {
        String loginId = request.getHeader("loginId");
        User user = userService.findByLoginId(loginId).get();

        String givenToken = request.getHeader("access-token");
        verifyToken(givenToken, user.getToken());

        return true;
    }

    private void verifyToken(String givenToken, String token) {
        Preconditions.checkArgument(!givenToken.equals(token), "Parameter Unmatch");

        jwtUtil.verifyToken(givenToken);
    }

}
