package br.com.fiap.FarmaNear_Receiver.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${api.security.token.secret.timeout:10}")
    private long timeout;

    public String generateToken(String login) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("FarmaNear")
                    .withSubject(login)
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);

            return "Bearer " + token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating jwt", e);
        }
    }

    public String getSubject(String token) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decodedJWT = JWT.require(algorithm).withIssuer("FarmaNear").build().verify(token);

            if (isExpired(decodedJWT)) {
                throw new RuntimeException("Token expired");
            }
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Error", e);
        }
    }

    private boolean isExpired(DecodedJWT decodedJWT) {
        Instant tokenExpiration = decodedJWT.getExpiresAt().toInstant();
        Instant currentTime = Instant.now().atOffset(ZoneOffset.of("-03:00")).toInstant();
        return currentTime.isAfter(tokenExpiration);
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusMinutes(timeout).toInstant(java.time.ZoneOffset.of("-03:00"));
    }
}
