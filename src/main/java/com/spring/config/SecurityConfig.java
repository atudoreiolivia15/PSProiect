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
                .csrf(csrf -> csrf.disable())  // Dezactivăm protecția CSRF pentru testare
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register", "/posts/getAll").permitAll()  // Permitem accesul la înregistrare și vizualizare posturi
                        .requestMatchers("/posts/create", "/posts/update/**", "/posts/delete/**").permitAll()  // Permite doar utilizatorilor autentificați să creeze, actualizeze și șteargă posturi
                        .anyRequest().authenticated() // Restul necesită autentificare
                )
                .formLogin(form -> form.disable())  // Dezactivăm login-ul cu formular
                .httpBasic(basic -> basic.disable())  // Dezactivăm autentificarea basic
                .build();
    }
}