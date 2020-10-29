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

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {

  @Value("${jwt.expiration}")
  private Long jwtExpirationInMillis;

  /**
   * Temporariry Hardcoded string
   */
  // @Value("${jwt.key}")
  private String secretKey = "oeRaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPBctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";

  SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

  //We will sign our JWT with our ApiKey secret
  byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
  Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

  /**
   * Generate a token for signed in user
   */
  public String generateToken(Authentication authentication) {
    UserDetails principal =  (UserDetails) authentication.getPrincipal();
    return Jwts.builder()
      .setSubject(principal.getUsername())
      .signWith(signingKey)
      .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
      .compact();
  }

  /**
   * Check token validity
   */
  public boolean validateToken(String jwt) {
    Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(jwt);
    return true;
  }

  /**
   * Feth username from JWT
   */
  public String getUsernameFromJwt(String token) {
    Claims claims = Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).getBody();
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
      .signWith(signingKey)
      .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis))).compact();
  }

}
