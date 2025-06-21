package com.devsenior.nmanja.course_security.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureAlgorithm;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private Key key;


    //Generacion del token
    public String generateToken(UserDetails userDetails){

        var claims = new HashMap<String, Object>();
        //Agregar información al token

        

        //crear el token con los claims
        return createToken(claims, userDetails.getUsername());
    }


    //Obtiene firma en una llave

    private Key getSignInKey(){

        //Variable que codifica la clave que tenemos en properties en base64
        key = Jwts.SIG.HS256.key().build();
        var keyBytes = Decoders.BASE64.decode(secret);

        //hashea la clave en bytes
        return key;

    }

    //Creacion del token
    private String createToken(Map<String,Object> claims, String username){

                //constructoru del token
        return Jwts.builder()
                    .claims(claims)
                    .subject(username)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + expiration))
                    .signWith(getSignInKey())
                    .compact();

    }
    
}
