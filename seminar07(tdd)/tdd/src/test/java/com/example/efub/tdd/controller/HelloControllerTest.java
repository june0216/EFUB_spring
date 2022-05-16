package com.example.efub.tdd.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //테스트 메소드를 실행하는 테스트 러너를 JUnit에 기본으로 내장된 실행자가 아닌, 다른 실행자로 지정(확장 가능)
@WebMvcTest(controllers = HelloController.class)//Spring MVC에 집중하여 보다 가벼운 테스트, MockBean 가짜 객체 사용
class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //API 테스트 가능

    @Test
    public void returnHello() throws Exception {
        // given
        String hello = "hello";

        // when / then
        mvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON)) //MockMVC기본 제공, URL요청하듯 컨트롤러 실행
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}