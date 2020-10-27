/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-09-25 22:41:27
 * @modify date 2020-09-25 22:41:27
 * @desc Main class
 */
package com.cg.inventorydatabaseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InventoryDatabaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryDatabaseServiceApplication.class, args);
	}

}
