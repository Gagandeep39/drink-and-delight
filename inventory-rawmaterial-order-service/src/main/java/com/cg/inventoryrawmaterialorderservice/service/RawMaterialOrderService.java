package com.cg.inventoryrawmaterialorderservice.service;

import java.util.List;

import com.cg.inventoryrawmaterialorderservice.entity.RawMaterial;
import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;

public interface RawMaterialOrderService {

	//Create an RawMaterialOrder type of order to save in database
	RawMaterialOrder createRawMaterialOrder(RawMaterialOrder order);
	
	//Update the Delivery status of the raw material ordered                       //Incomplete
	RawMaterialOrder updateRawMaterialOrderDeliveryStatus();
	
	//Find a particular Raw material by its Id                                  //Incomplete
	RawMaterial fetchRawMaterialById(Integer id) ;
	
	//Fetch all Raw material orders
	List<RawMaterialOrder> fetchAllOrders();
}
