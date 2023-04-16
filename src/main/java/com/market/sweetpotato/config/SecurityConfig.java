package com.market.sweetpotato.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable(); // web 기본 인증 방식
        http.formLogin().disable(); // form 기반 인증 방식
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 사용하지 않음

        http.authorizeRequests()
                .antMatchers("/member/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
