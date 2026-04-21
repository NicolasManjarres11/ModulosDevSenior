package com.devsenior.nmanja.user_login.service.impl;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devsenior.nmanja.user_login.exception.BadLoginException;
import com.devsenior.nmanja.user_login.mapper.UserMapper;
import com.devsenior.nmanja.user_login.model.dto.LoginRequest;
import com.devsenior.nmanja.user_login.model.dto.LoginResponse;
import com.devsenior.nmanja.user_login.model.dto.RegisterRequest;
import com.devsenior.nmanja.user_login.model.dto.RegisterResponse;
import com.devsenior.nmanja.user_login.repository.UserRepository;
import com.devsenior.nmanja.user_login.service.AuthService;
import com.devsenior.nmanja.user_login.service.JwtService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AuthServicePostgresql implements AuthService{
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    //private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register(RegisterRequest userInfo) {

        //TODO:Verificar que el username no exista

        //TODO:Verificar que el correo no exista en la base de datos

        //Creo una entidad con los datos del RequestDTO

        var user = userMapper.toEntity(userInfo);

        //Encripte la contraseña enviada por el usuario

        //user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);

        //Guardo en la base de datos

        //Devuelvo el objeto guardado como ResponseDTO

        // TODO Auto-generated method stub
        return userMapper.toResponse(user);
    }

    @Override
    public LoginResponse login(LoginRequest credentials) {


        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            credentials.getUsername(), 
            credentials.getPassword()));

        var userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
        var userInfo = userRepository.findById(credentials.getUsername());
        //var token = jwtService.generateToken(userDetails);
        Map<String, Object> claims = Map.of();
        if(userInfo.isPresent()){
            claims =         Map.<String, Object>of(
                "name", userInfo.get().getName(),
                "role",userInfo.get().getRole().toString());
        }
        


        var token = jwtService.generateToken(claims, userDetails);

        return LoginResponse.builder()
                .jwt(token)
                .build();

    }

}
