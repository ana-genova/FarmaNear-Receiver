package br.com.fiap.FarmaNear_Receiver.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(String login) {
    try {
      var algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer("FarmaNear")
          .withSubject(login)
          .withExpiresAt(expirationDate())
          .sign(algorithm);
    } catch (JWTCreationException e){
      throw new RuntimeException("Error generating jwt", e);
    }
  }

  private Instant expirationDate() {
    return LocalDateTime.now().plusMinutes(30).toInstant(java.time.ZoneOffset.of( "-03:00"));
  }
}
