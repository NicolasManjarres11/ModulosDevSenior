package com.devsenior.nmanja.property_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    
    private String secret = "miClaveSecretaSuperSeguraParaJWT2025DevSeniorNmanjaPropertyService";
    private long expiration = 86400000; // 24 horas en milisegundos
    private String issuer = "property-service";
    private String audience = "property-service-users";
}
