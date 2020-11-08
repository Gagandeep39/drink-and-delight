/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 00:14:03
 * @modify date 2020-10-30 00:14:03
 * @desc Raw Material Management Endpoint
 */
package com.cg.inventoryrawmaterialorderservice.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderRequest;
import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderResponse;
import com.cg.inventoryrawmaterialorderservice.dto.UpdateStatusDto;
import com.cg.inventoryrawmaterialorderservice.service.RawMaterialOrderService;

@RestController
@RequestMapping("/rawMaterialOrder")
@CrossOrigin(origins = "*")
public class RawMaterialOrderController {

	@Autowired
	private RawMaterialOrderService service;

	// Create Order
	@PostMapping
	public ResponseEntity<Map<String, String>> createOrder(
			@Valid @RequestBody RawMaterialOrderRequest rawMaterialOrderRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.createRawMaterialOrder(rawMaterialOrderRequest));
	}

	// Update Delivery Status
	@PutMapping
	public ResponseEntity<RawMaterialOrderResponse> UpdateDeliveryStatus(@Valid @RequestBody UpdateStatusDto updateStatusDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.service.updateRawMaterialOrderDeliveryStatus(updateStatusDto));
	}

	// Find a particular order by its ID
	@GetMapping("/{id}")
	public ResponseEntity<RawMaterialOrderResponse> findRawMaterialOrderById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.fetchRawMaterialOrderById(id));
	}

	// Fetch all the Orders
	@GetMapping
	public ResponseEntity<List<RawMaterialOrderResponse>> FetchAllOrders() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.fetchAllOrders());
	}

}
