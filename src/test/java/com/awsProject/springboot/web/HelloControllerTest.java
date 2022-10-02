package com.awsProject.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

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
}