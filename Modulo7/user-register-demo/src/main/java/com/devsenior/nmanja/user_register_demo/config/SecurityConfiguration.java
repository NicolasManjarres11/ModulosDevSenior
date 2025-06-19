package com.devsenior.nmanja.user_register_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/","/index.html").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/user/register").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/books/loan").hasAnyRole("ADMIN","USER")  //Define los permisos del rol
                .requestMatchers("/api/books/**","/api/user/**").hasRole("ADMIN")
                    .anyRequest().authenticated())
            .httpBasic(basic -> {})
            ;

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //Codificamos en base64
    }

    @Bean //Contraseña manual guardada en memoria
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails user = User.builder()
        .username("user")
        .password(passwordEncoder.encode("123456"))
        .roles("ADMIN")
        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
