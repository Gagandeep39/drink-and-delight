package com.cg.inventoryrawmaterialorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InventoryRawmaterialOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryRawmaterialOrderServiceApplication.class, args);
	}

}
