package com.devsenior.nmanja.user_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.devsenior.nmanja.user_login.mapper.UserMapper;

@Configuration
public class BeanConfiguration {

    @Bean
    UserMapper userMapper(PasswordEncoder passwordEncoder){
        return new UserMapper(passwordEncoder);
    }


    
}
