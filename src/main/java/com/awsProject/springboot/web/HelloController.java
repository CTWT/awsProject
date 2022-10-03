package com.awsProject.springboot.web;

import com.awsProject.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어줍니다
@RestController
public class HelloController {

    //HTTP method인 Get의 요청을 받을수 있는 API 제작
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // RequestParam 외부에서 넘긴 파라미터를 가져오는 어노테이션
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
