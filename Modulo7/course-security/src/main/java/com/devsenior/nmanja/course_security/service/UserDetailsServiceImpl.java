package com.devsenior.nmanja.course_security.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsenior.nmanja.course_security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class UserDetailsServiceImpl implements UserDetailsService{ 
//Interfaz implementada para determinar como sacar la informacion del usuario de la base de datos

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        var user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("No existe un usuario con el nombre "+ username));

        var authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role)) //Convierte cada rolo traido de la base de datos a Authority
            .toList();

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    
    
}
