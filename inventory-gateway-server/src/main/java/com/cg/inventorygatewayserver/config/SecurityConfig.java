/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-29 16:50:12
 * @modify date 2020-10-29 16:50:12
 * @desc Security COnfiguration
 */
package com.cg.inventorygatewayserver.config;

import java.util.Arrays;

import com.cg.inventorygatewayserver.security.CustomAuthenticationEntryPoint;
import com.cg.inventorygatewayserver.security.JwtAuthenticationFilter;
import com.cg.inventorygatewayserver.service.implementation.JwtUserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@AllArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private JwtAuthenticationFilter jwtAuthenticationFilter;
  private JwtUserDetailsServiceImpl userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    .cors()
    .configurationSource(request -> {
        CorsConfiguration source = new CorsConfiguration();
        source.applyPermitDefaultValues();
        // .applyPermitDefaultValues(); only allows GET, HEAD, POST
        source.setAllowedMethods(Arrays.asList("GET", "HEAD", "POST", "DELETE", "PUT"));
      return source;
      }).and() // Required for accessing prpotected routes
      .csrf().disable()
      .authorizeRequests().antMatchers("/inventory-auth-service/**", "/actuator/**", "/**/h2/**", "/**/swagger*/**", "/**/v2/api-docs").permitAll().antMatchers("/h2").permitAll()
      .anyRequest().authenticated()
      .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    http.headers().frameOptions().disable();
  }

  /**
   * Password Encodeer DI
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  /**
   * In @Bean(BeanIds.AUTHENTICATION_MANAGER) NeanIds part is optional
   */
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  /**
   * DI for CustomAuthentiaction EntryPoint
   */
  public AuthenticationEntryPoint authenticationEntryPoint() {
    return new CustomAuthenticationEntryPoint();
  }

}
