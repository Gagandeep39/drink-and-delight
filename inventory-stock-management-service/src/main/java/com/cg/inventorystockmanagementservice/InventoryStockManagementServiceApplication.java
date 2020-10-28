package com.cg.inventorystockmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InventoryStockManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryStockManagementServiceApplication.class, args);
	}

}
