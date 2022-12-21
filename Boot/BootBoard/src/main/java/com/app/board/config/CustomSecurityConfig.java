package com.app.board.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //권한에 따른 접속
        // user : /board/**, reply/**, /todo/**
        //admin : /admin/**
        // 나머지 요청 경로 : ahengjrk
        http.authorizeHttpRequests().antMatchers("/board/**","reply/**","/todo/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll();

        // form 로그인 페이지에 대한 설정, 성공시 처리 핸들러 등록
        http.formLogin(); /*.loginPage("/auth/login");*/
        // /auth/login 요청 페이지는 사용자가 직접 만든 페이지

        //로그아웃
        http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
        // /auth/logout => Security가 자동 매핑

        // 자동 로그인
        http.rememberMe().key("123456789").rememberMeParameter("remember-me").tokenValiditySeconds(60*60*60*24*7);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
