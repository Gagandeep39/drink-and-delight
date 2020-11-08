package com.cg.inventoryproductorderservice.controller;

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

import com.cg.inventoryproductorderservice.dto.ProductOrderRequest;
import com.cg.inventoryproductorderservice.dto.ProductOrderResponse;
import com.cg.inventoryproductorderservice.dto.UpdateStatusDto;
import com.cg.inventoryproductorderservice.service.ProductOrderService;

@RestController
@RequestMapping("/productOrder")
@CrossOrigin(origins = "*")
public class ProductOrderController {

	@Autowired
	ProductOrderService productOrderService;

	@PostMapping
	public ResponseEntity<Map<String, String>> createProductOrderRequest(
			@Valid @RequestBody ProductOrderRequest productOrderRequest) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.productOrderService.createProductOrder(productOrderRequest));
	}

	@GetMapping
	public ResponseEntity<List<ProductOrderResponse>> fetchAllProductOrders() {
		return ResponseEntity.status(HttpStatus.OK).body(this.productOrderService.fetchAllProductOrders());
	}

	@PutMapping
	public ResponseEntity<ProductOrderResponse> UpdateDeliveryStatus(
			@Valid @RequestBody UpdateStatusDto updateStatusDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.productOrderService.updateProductOrderDeliveryStatus(updateStatusDto));
	}

	@GetMapping("/{productOrderId}")
	public ResponseEntity<ProductOrderResponse> getProductOrderById(@PathVariable long productOrderId) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.productOrderService.fetchProductOrderById(productOrderId));
	}
}
