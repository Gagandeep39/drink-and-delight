/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-29 11:18:45
 * @modify date 2020-10-29 11:18:45
 * @desc Exception handler form unauhenticated request
 */
package com.cg.inventorygatewayserver.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {

        // Causes CORS Error - Http OK status
    // response.setStatus(HttpStatus.FORBIDDEN.value());
    // response.setContentType("application/json;charset=UTF-8");
    // Map<String, Object> data = new HashMap<>();
    // data.put("timestamp", System.currentTimeMillis());
    // data.put("status", HttpStatus.FORBIDDEN.value());
    // data.put("message", "Access Denied");
    // OutputStream out = response.getOutputStream();
    // ObjectMapper mapper = new ObjectMapper();
    // mapper.writeValue(out, data);
  }

}
