/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 00:21:32
 * @modify date 2020-10-30 00:21:32
 * @desc RM Bussiness Logic
 */
package com.cg.inventoryrawmaterialorderservice.service.implementation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderRequest;
import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderResponse;
import com.cg.inventoryrawmaterialorderservice.dto.UpdateStatusDto;
import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;
import com.cg.inventoryrawmaterialorderservice.enums.OrderStatus;
import com.cg.inventoryrawmaterialorderservice.exception.InvalidOrderUpdateStatusException;
import com.cg.inventoryrawmaterialorderservice.exception.RawMaterialNotFoundException;
import com.cg.inventoryrawmaterialorderservice.helper.RawMaterialMapper;
import com.cg.inventoryrawmaterialorderservice.repository.RawMaterialOrderRepository;
import com.cg.inventoryrawmaterialorderservice.service.RawMaterialOrderService;

@Service
public class RawMaterialOrderServiceImpl implements RawMaterialOrderService {

	@Autowired
	private RawMaterialOrderRepository repository;

	// Create an RawMaterialOrder type of order to save in database
	public Map<String, String> createRawMaterialOrder(RawMaterialOrderRequest order) {
		return Collections.singletonMap("rawMaterialOrderId", repository.save(RawMaterialMapper.DtoToEntity(order)).getRawMaterialOrderId().toString());
	}

	// Update the Delivery status of the raw material ordered
	public RawMaterialOrderResponse updateRawMaterialOrderDeliveryStatus(UpdateStatusDto updateStatusDto) {
		RawMaterialOrder order = repository.findById(updateStatusDto.getOrderId()).orElseThrow(() -> new RawMaterialNotFoundException("rawMaterial", "Not found"));
		if(order.getOrderStatus().equals(OrderStatus.Delivered)) throw new InvalidOrderUpdateStatusException("status", "Product already delivered");
		if (order.getOrderStatus().equals(OrderStatus.Cancelled)) throw new InvalidOrderUpdateStatusException("status", "Product delivery was cancelled before");
		order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));
		return RawMaterialMapper.entityToDto(this.repository.save(order));
	}

	// Find a particular Raw material order by its Id
	public RawMaterialOrderResponse fetchRawMaterialOrderById(Long id) {
		return RawMaterialMapper.entityToDto(this.repository.findById(id).orElseThrow(() -> new RawMaterialNotFoundException("rawMaterial", "Not found")));
	}

	// Fetch all Raw material orders
	public List<RawMaterialOrderResponse> fetchAllOrders() {
		return this.repository.findAll().stream().map(RawMaterialMapper::entityToDto).collect(Collectors.toList());
	}
}
