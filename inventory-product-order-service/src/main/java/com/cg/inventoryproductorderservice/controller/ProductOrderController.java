package com.cg.inventoryproductorderservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventoryproductorderservice.dto.ProductOrderRequest;
import com.cg.inventoryproductorderservice.dto.ProductOrderResponse;
import com.cg.inventoryproductorderservice.dto.UpdateStatusDto;
import com.cg.inventoryproductorderservice.entity.ProductOrder;
import com.cg.inventoryproductorderservice.exception.ProductOrderIdNotFoundException;
import com.cg.inventoryproductorderservice.service.ProductOrderServiceImpl;

@RestController
@RequestMapping("/productOrder")
public class ProductOrderController {

	@Autowired
	ProductOrderServiceImpl productOrderService;

	@RequestMapping(value = "/addProductOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrderResponse> createProductOrderRequest(
			@Valid @RequestBody ProductOrderRequest productOrderRequest) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.productOrderService.createProductOrder(productOrderRequest));
	}

	@GetMapping("/fetchAllProductOrders")
	public ResponseEntity<List<ProductOrderResponse>> fetchAllProductOrders() {
		System.out.println("In Controller ServiceFetchall");
		return ResponseEntity.status(HttpStatus.OK).body(this.productOrderService.fetchAllProductOrders());
	}

	@PutMapping("/updateProductOrder")
	public ResponseEntity<ProductOrderResponse> UpdateDeliveryStatus(
			@Valid @RequestBody UpdateStatusDto updateStatusDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.productOrderService.updateProductOrderDeliveryStatus(updateStatusDto));
	}

	@GetMapping("/getProductorderdById/{productOrderId}")
	public ResponseEntity<ProductOrderResponse> getProductOrderById(@PathVariable long productOrderId) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.productOrderService.fetchProductOrderById(productOrderId));
	}
}
