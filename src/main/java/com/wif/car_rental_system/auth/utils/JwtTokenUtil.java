package com.wif.car_rental_system.auth.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wif.car_rental_system.users.domain.entities.UserEntity;

@Service
public class JwtTokenUtil {

  @Value("${JWT_SECRET}")
  private String JWT_SECRET;

  @Value("${JWT_EXPIRATION_HOURS}")
  private Integer JWT_EXPIRATION_HOURS;

  @Value("${JWT_RECOVERY_EXPIRATION_MINUTES}")
  private Integer JWT_RECOVERY_EXPIRATION_MINUTES;

  @Value("${JWT_TIMEZONE_OFFSET}")
  private String JWT_TIMEZONE_OFFSET;

  private final String EMAIL_CLAIM = "email";
  private final String RECOVERY_CLAIM = "recovery";

  public String genAccessToken(UserEntity user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

      Instant expirationDate = LocalDateTime.now().plusHours(JWT_EXPIRATION_HOURS)
          .toInstant(ZoneOffset.of(JWT_TIMEZONE_OFFSET));

      return JWT.create()
          .withSubject(user.getUsername())
          .withClaim(EMAIL_CLAIM, user.getUsername())
          .withExpiresAt(expirationDate)
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      throw new JWTCreationException("Error while generating token", exception);
    }
  }

  public String genRecoveryKeyToken(UserEntity user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

      Instant expirationDate = LocalDateTime.now().plusMinutes(JWT_RECOVERY_EXPIRATION_MINUTES)
          .toInstant(ZoneOffset.of(JWT_TIMEZONE_OFFSET));

      return JWT.create()
          .withSubject(user.getUsername())
          .withClaim(EMAIL_CLAIM, user.getUsername())
          .withClaim(RECOVERY_CLAIM, true)
          .withExpiresAt(expirationDate)
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      throw new JWTCreationException("Error while generating token", exception);
    }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

      return JWT.require(algorithm)
          .build()
          .verify(token)
          .getSubject();
    } catch (JWTVerificationException exception) {
      throw new JWTVerificationException("Error while validating token", exception);
    }
  }

  public boolean isRecoveryToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

      return JWT.require(algorithm)
          .build()
          .verify(token)
          .getClaim(RECOVERY_CLAIM)
          .asBoolean();
    } catch (JWTVerificationException exception) {
      throw new JWTVerificationException("Error while validating token", exception);
    }
  }
}
