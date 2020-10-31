/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 03:03:31
 * @modify date 2020-10-31 03:03:31
 * @desc Performs Load balancing
 */
package com.cg.inventoryproductorderservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LoadBalancerConfig {

  public static final String LOADBALANCED = "loadbalanced";
  public static final String STANDARD = "standard";

  @LoadBalanced
  @Bean
  @Qualifier(LOADBALANCED)
  public RestTemplate loadBalancedRestTemplate() {
    return new RestTemplate();
  }

  // @Bean
  // @Qualifier(STANDARD)
  // public RestTemplate restTemplate() {
  //   return new RestTemplate();
  // }

}
