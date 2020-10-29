package com.cg.inventoryrawmaterialorderservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;
import com.cg.inventoryrawmaterialorderservice.service.RawMaterialOrderService;

@RestController
public class RawMaterialOrderController {

	@Autowired
	private RawMaterialOrderService service;
	
	//Create Order
	@PostMapping(value = "/rawMaterial")
	public RawMaterialOrder createOrder(@RequestBody RawMaterialOrder rawMaterialOrder) {
		return this.service.createRawMaterialOrder(rawMaterialOrder);
	}
	
	//Update Delivery Status                                                 
	@PutMapping(value = "/rawMaterial")
	public RawMaterialOrder UpdateDeliveryStatus(@RequestBody RawMaterialOrder order) {
		return this.service.updateRawMaterialOrderDeliveryStatus(order);
	}
	
	//Find a particular order by its ID
	@GetMapping(value = "/rawMaterial/{id}")
	public Optional<RawMaterialOrder> findRawMaterialOrderById(@PathVariable Long id){
		return this.service.fetchRawMaterialOrderById(id);
	}
	
	//Fetch all the Orders
	@GetMapping(value = "/rawMaterial")
	public List<RawMaterialOrder> FetchAllOrders(){
		return this.service.fetchAllOrders();
	}
	
}
