package com.devsenior.nmanja.jwt_exercise.config;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.userdetails.User;


import com.devsenior.nmanja.jwt_exercise.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                var authHeader = request.getHeader("Authorization");

                if(authHeader == null || !authHeader.startsWith("Bearer")){

                    log.info("La petición no tiene token");
                    filterChain.doFilter(request, response);
                    return;
                }

                var token = authHeader.substring(7);
                log.info("El token es: {}",token);
                var username = jwtUtil.extractUsername(token);
                log.info("El username es: {}", username);

                var authentication = SecurityContextHolder.getContext().getAuthentication();

                if(username != null && authentication == null){
                    log.info("Hay que cargar el usuario al contexto");
/*                     var userDetails = userDetailsService.loadUserByUsername(username); */

                    List<String> roles = jwtUtil.extractClaims(token, (claim) -> {
                        log.info("Roles {}",claim.get("roles"));
                        return (List<String>) claim.get("roles");
                    });

                    log.info("Roles: {}", roles);

                    var userDetails = new User(username, "0", 
                    roles.stream()
                        .map(e -> new SimpleGrantedAuthority(e))
                        .toList());

                    if(jwtUtil.validateToken(token, userDetails)){
                        
                        //User, password, roles o authorities
                        var authToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities()); 
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);

                    }

                    filterChain.doFilter(request, response);
                }

        
    }

    
    
}
