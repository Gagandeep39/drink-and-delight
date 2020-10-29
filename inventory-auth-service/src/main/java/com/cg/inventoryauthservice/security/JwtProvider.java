/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-29 09:27:24
 * @modify date 2020-10-29 09:27:24
 * @desc JWT Helper methods to encode, decode tokens etc
 */
package com.cg.inventoryauthservice.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

  @Value("${jwt.expiration}")
  private Long jwtExpirationInMillis;

  @Value("${jwt.key}")
  private String secretKey;

  /**
   * Generate a token for signed in user
   */
  public String generateToken(Authentication authentication) {
    UserDetails principal =  (UserDetails) authentication.getPrincipal();
    return Jwts.builder()
      .setSubject(principal.getUsername())
      .signWith(getSigningKey())
      .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
      .compact();
  }

  /**
   * Check token validity
   */
  public boolean validateToken(String jwt) {
    Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt);
    return true;
  }

  /**
   * Feth username from JWT
   */
  public String getUsernameFromJwt(String token) {
    Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    return claims.getSubject();
  }

  public long getExpirationInMillis() {
    return jwtExpirationInMillis;
  }

  /**
   * Generate token based on username
   * @param username User for which toke is to be generated
   * @return Token
   */
  public String generateTokenWithUsername(String username) {
    return Jwts.builder()
      .setSubject(username)
      .setIssuedAt(Date.from(Instant.now()))
      .signWith(getSigningKey())
      .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis))).compact();
  }

  /**
   * Convert string into Byte array as Jwt 1.0 + doesnt suport string
   */
  private Key getSigningKey() {
    byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
