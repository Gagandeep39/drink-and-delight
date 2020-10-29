/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-29 16:18:08
 * @modify date 2020-10-29 16:18:08
 * @desc Discovery client confi
 */
package com.cg.inventoryrawmaterialorderservice.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Profile;

@Profile("!test")
@EnableDiscoveryClient
public class DiscoveryClientConfig {
  
}
