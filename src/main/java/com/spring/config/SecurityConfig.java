package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())  // Dezactivare protecția CSRF pentru testare
                .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/users/register","/users/getAll","/users/update/{id}","/users/delete/{id}").permitAll()
                        .requestMatchers("/posts/create/**", "/posts/update/**", "/posts/delete/**","/posts/getAll").permitAll()
                        .requestMatchers("/votes/create", "/votes/update/**", "/votes/delete/**","/votes/getAll").permitAll()
                        .requestMatchers("/comments/create/**").permitAll()
                )
                //.formLogin(form -> form.disable())  // Dezactivez login-ul cu formular
                //.httpBasic(basic -> basic.disable())  // Dezactivez autentificarea basic
                .build();
    }
}