package com.awsProject.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어줍니다
@RestController
public class HelloController {

    //HTTP method인 Get의 요청을 받을수 있는 API 제작
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
