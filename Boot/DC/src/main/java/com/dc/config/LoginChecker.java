package com.dc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LoginChecker {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception
    {
        security.csrf().disable();

        security.formLogin();

        security.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        security.rememberMe().key("123456789").rememberMeParameter("remember-me").tokenValiditySeconds(300);

        return security.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
