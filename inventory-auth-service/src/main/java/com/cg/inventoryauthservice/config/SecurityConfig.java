package com.cg.inventoryauthservice.config;

import com.cg.inventoryauthservice.security.CustomAuthenticationEntryPoint;
import com.cg.inventoryauthservice.security.JwtAuthenticationFilter;
import com.cg.inventoryauthservice.service.implementation.JwtUserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
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

import lombok.AllArgsConstructor;

@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private JwtAuthenticationFilter jwtAuthenticationFilter;
  private JwtUserDetailsServiceImpl userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
      .authorizeRequests().antMatchers("/auth/**").permitAll().antMatchers("/h2").permitAll()
      .anyRequest().authenticated()
      .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
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
