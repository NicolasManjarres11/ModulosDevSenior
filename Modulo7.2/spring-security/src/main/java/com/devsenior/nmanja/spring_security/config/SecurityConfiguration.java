package com.devsenior.nmanja.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Carga las configuraciones antes de ejecutar los demás elementos
@EnableWebSecurity //Carga las reglas de la seguridad web


public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authz -> authz

                .requestMatchers("/","/index.html").permitAll()
                .requestMatchers("/api/public").permitAll()
                .requestMatchers(HttpMethod.GET).hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                .anyRequest().denyAll())
            //.formLogin(login -> {})
            .httpBasic(basic -> {})
            ;

        return http.build();

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

        var user1 = User.builder()
            .username("nico")
            .password(passwordEncoder.encode("admin123"))
            .authorities("ROLE_ADMIN")
            .build();

        var user2 = User.builder()
            .username("dayana")
            .password(passwordEncoder.encode("admin123"))
            .authorities("ROLE_USER")
            .build();



        return new InMemoryUserDetailsManager(user1, user2);
    }
    
}
