package com.cg.inventoryrawmaterialorderservice.service;

import java.util.List;

import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderRequest;
import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderResponse;
import com.cg.inventoryrawmaterialorderservice.dto.UpdateStatusDto;

public interface RawMaterialOrderService {

	//Create an RawMaterialOrder type of order to save in database
	RawMaterialOrderResponse createRawMaterialOrder(RawMaterialOrderRequest orderRequest);
	
	//Update the Delivery status of the raw material ordered                       
	RawMaterialOrderResponse updateRawMaterialOrderDeliveryStatus(UpdateStatusDto updateStatusDto);
	
	//Find a particular Raw material order by its Id                                  
	RawMaterialOrderResponse fetchRawMaterialOrderById(Long id) ;
	
	//Fetch all Raw material orders
	List<RawMaterialOrderResponse> fetchAllOrders();
}
