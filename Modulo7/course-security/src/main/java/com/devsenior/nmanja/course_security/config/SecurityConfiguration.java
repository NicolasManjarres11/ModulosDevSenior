package com.devsenior.nmanja.course_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        ////Evita la posibilidad de que en un ataque realicen acciones maliciosas haciendolo desde el perfil del usuario autenticado
        http.csrf(csrf ->
                        csrf.disable())  
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(authz -> authz  //Para cada request, debe estar autenticado
/*                 .requestMatchers("/api/**").hasAuthority("ADMIN") */
/*                     .requestMatchers(HttpMethod.GET, "/api/cursos").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/cursos").hasAnyRole("USER","ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/cursos").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/cursos/*").hasRole("ADMIN") */
                    .anyRequest().authenticated())
                    .httpBasic(basic -> {})
                ; 

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
