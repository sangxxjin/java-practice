package org.sangxxjin.javapractice.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain baseSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/h2-console/**")
                    .permitAll()
                    .requestMatchers("/h2-console/login.do") // 상위룰 우선이기 때문에, 의미 없음
                    .authenticated() // 상위룰 우선이기 때문에, 의미 없음
                    .requestMatchers(HttpMethod.GET, "/api/*/posts/{id:\\d+}", "/api/*/posts", "/api/*/posts/{postId:\\d+}/comments")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            )
            .headers(
                headers ->
                    headers.frameOptions(
                        frameOptions ->
                            frameOptions.sameOrigin()
                    )
            )
            .csrf(
                csrf ->
                    csrf.disable()
            );
        return http.build();
    }
}