/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-25 22:35:47
 * @modify date 2020-09-25 22:35:47
 * @desc Eureka Server Root
 */
package com.cg.inventorydiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class InventoryDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryDiscoveryServerApplication.class, args);
	}

}
