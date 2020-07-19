package com.jaewoo.toy.biz.user.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaewoo.toy.biz.user.domain.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void createUser() throws Exception {
        // given
        UserDto.CreateRequest createRequest = new UserDto.CreateRequest();
        createRequest.setLoginId("jaewoo7");
        createRequest.setFirstName("Jaewoo");
        createRequest.setLastName("Jung");
        createRequest.setPassword("1234");

        // when
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                        .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(status().isOk())
                .andDo(print());

        // then
    }
}