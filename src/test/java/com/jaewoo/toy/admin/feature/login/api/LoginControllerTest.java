package com.jaewoo.toy.admin.feature.login.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaewoo.toy.admin.feature.login.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest
class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void login() throws Exception {
        UserDto.LoginRequest dto = new UserDto.LoginRequest();
        dto.setLoginId("jeawoo.jeong");
        dto.setPassword("1234");

        ResultActions result = mvc.perform(post("/api/login/")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .header("loginId", "jeawoo.jeong")
                                            .header("access-token", "11111")
                                            .content(mapper.writeValueAsString(dto)))
                                        .andDo(print());
    }
}