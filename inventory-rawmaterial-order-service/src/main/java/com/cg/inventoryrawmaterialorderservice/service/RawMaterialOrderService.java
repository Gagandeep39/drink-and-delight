package com.cg.inventoryrawmaterialorderservice.service;

import java.util.List;

import com.cg.inventoryrawmaterialorderservice.dto.UpdateStatusDto;
import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;

public interface RawMaterialOrderService {

	//Create an RawMaterialOrder type of order to save in database
	RawMaterialOrder createRawMaterialOrder(RawMaterialOrder order);
	
	//Update the Delivery status of the raw material ordered                       
	RawMaterialOrder updateRawMaterialOrderDeliveryStatus(UpdateStatusDto updateStatusDto);
	
	//Find a particular Raw material order by its Id                                  
	RawMaterialOrder fetchRawMaterialOrderById(Long id) ;
	
	//Fetch all Raw material orders
	List<RawMaterialOrder> fetchAllOrders();
}
