package com.jaewoo.toy.admin.feature.login.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaewoo.toy.admin.feature.login.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void login() throws Exception {
        UserDto.LoginRequest dto = new UserDto.LoginRequest();
        dto.setLoginId("jaewo7o@naver.com");
        dto.setPassword("1234");

        ResultActions result = mvc.perform(post("/api/login/")
                                            .accept(MediaType.APPLICATION_JSON)
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .header("loginId", "jeawoo.jeong")
                                            .header("access-token", "11111")
                                            .content(mapper.writeValueAsString(dto)))
                                        .andExpect(MockMvcResultMatchers.status().isOk())
                                        .andDo(print());
    }
}