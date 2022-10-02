package com.awsProject.springboot.web.dto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        /*
        * assertj라는 테스트 검증 라이브러리 검증 메소드
        * 검증하고 싶은 대상을 메소드 인자로 받음
        * isEqualTo는 assertj와 비교하며 값이 같을 경우만 성공
        * */
    }
}