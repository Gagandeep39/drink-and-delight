package com.cg.inventoryrawmaterialorderservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;
import com.cg.inventoryrawmaterialorderservice.exception.RawMaterialNotFoundException;
import com.cg.inventoryrawmaterialorderservice.repository.RawMaterialOrderRepository;
import com.cg.inventoryrawmaterialorderservice.service.RawMaterialOrderService;

@Service
public class RawMaterialOrderServiceImpl implements RawMaterialOrderService {
	
	@Autowired
	private RawMaterialOrderRepository repository;
	
	//Create an RawMaterialOrder type of order to save in database
	public RawMaterialOrder createRawMaterialOrder(RawMaterialOrder order) {
		return this.repository.save(order);
	}
	
	//Update the Delivery status of the raw material ordered                       
	public RawMaterialOrder updateRawMaterialOrderDeliveryStatus(RawMaterialOrder order) {
		return this.repository.save(order);
	}
	
	//Find a particular Raw material order by its Id                                  
	public RawMaterialOrder fetchRawMaterialOrderById(Long id) {
		return this.repository.findById(id).orElseThrow(() -> new RawMaterialNotFoundException("rawMaterial", "Not found"));
	}
	
	//Fetch all Raw material orders
	public List<RawMaterialOrder> fetchAllOrders(){
		return this.repository.findAll();
	}
}
