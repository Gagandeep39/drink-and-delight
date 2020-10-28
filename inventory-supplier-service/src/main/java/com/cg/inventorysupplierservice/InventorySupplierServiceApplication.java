package com.cg.inventorysupplierservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InventorySupplierServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorySupplierServiceApplication.class, args);
	}

}
