package com.awsProject.springboot.config.auth;

import com.awsProject.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  // Spring Security 설정 활성화 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면 사용위한 옵션 disable
                .and()
                .authorizeRequests()    // URL별 권한 관리 설정 옵션의 시작점  antMatchers옵셥 사용을 휘한 선언
                .antMatchers("/", "/css/**", "/image/**", "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())    // 권한 관리 대상지정 옵션
                .anyRequest().authenticated()   // 설정 값 제외 url을 나타냄 authenticated 옵션으로 인증된 사용자에게 허용
                .and()
                .logout()
                .logoutSuccessUrl("/")  // 로그아웃 기능에 대한 여러 설정의 진입점 성공시 /로 이동
                .and()
                .oauth2Login() //oauth 설정 진입
                .userInfoEndpoint()// 로그인 성공후 사용자 정보 설정
                .userService(customOAuth2UserService);
                // 소셜 로그인 성공 시 후속 조치를 진행할 구현체 등록
    }

}
