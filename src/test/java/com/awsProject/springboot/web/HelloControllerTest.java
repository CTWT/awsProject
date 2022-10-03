package com.awsProject.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)    //테스트를 진행할때 junit에 내장된 실행자 외에 다른 실행자를 실행시킵니다
@WebMvcTest(controllers = HelloController.class)    //web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    //스프링이 관리하는 bean을 주입받음
    @Autowired
    private MockMvc mvc;    // 웹 api를 테스트할 때 사용

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //HTTP Header의 Status검증
                .andExpect(content().string(hello));    // Controller에 있는 값과 같은지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name ="hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)        // API요청 파라미터를 설정 String 값만 허용되어 모두 문자열로 변경해야만 사용가능
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))    //Json응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));// $를 기준으로 필드명을 명시하여 검증한다.
    }
}