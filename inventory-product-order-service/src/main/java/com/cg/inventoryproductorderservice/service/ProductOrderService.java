package com.cg.inventoryproductorderservice.service;

import java.util.List;
import java.util.Map;

import com.cg.inventoryproductorderservice.dto.ProductOrderRequest;
import com.cg.inventoryproductorderservice.dto.ProductOrderResponse;
import com.cg.inventoryproductorderservice.dto.UpdateStatusDto;

public interface ProductOrderService {

	ProductOrderResponse fetchProductOrderById(long productOrderId);
	
	List<ProductOrderResponse> fetchAllProductOrders();
	
	ProductOrderResponse updateProductOrderDeliveryStatus(UpdateStatusDto updateStatusDto);
	
	Map<String, String> createProductOrder(ProductOrderRequest productOrder);
	
}
