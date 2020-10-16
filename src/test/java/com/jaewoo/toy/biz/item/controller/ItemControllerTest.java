package com.jaewoo.toy.biz.item.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaewoo.toy.biz.item.domain.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getItems() throws Exception {
        // given

        // when
        MvcResult mvcResult = mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        // then
        List<Item> items = mapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);

        Assertions.assertThat(items).isNotEmpty();

    }
}