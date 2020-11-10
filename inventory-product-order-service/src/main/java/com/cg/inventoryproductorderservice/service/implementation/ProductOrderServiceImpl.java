package com.cg.inventoryproductorderservice.service.implementation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventoryproductorderservice.dto.ProductOrderRequest;
import com.cg.inventoryproductorderservice.dto.ProductOrderResponse;
import com.cg.inventoryproductorderservice.dto.UpdateStatusDto;
import com.cg.inventoryproductorderservice.entity.ProductOrder;
import com.cg.inventoryproductorderservice.enums.OrderStatus;
import com.cg.inventoryproductorderservice.exception.InvalidOrderUpdateStatusException;
import com.cg.inventoryproductorderservice.exception.ProductOrderIdNotFoundException;
import com.cg.inventoryproductorderservice.helper.ProductOrderMapper;
import com.cg.inventoryproductorderservice.repository.ProductOrderRepository;
import com.cg.inventoryproductorderservice.service.ProductOrderService;
import com.cg.inventoryproductorderservice.service.UpdateStockService;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	private ProductOrderRepository orderRepository;

	@Autowired
	private UpdateStockService updateStockService;

	@Override
	public ProductOrderResponse fetchProductOrderById(long productOrderId) {
		return ProductOrderMapper.entityToDto(this.orderRepository.findById(productOrderId)
				.orElseThrow(() -> new ProductOrderIdNotFoundException("productOrderId", "Not found")));
	}

	@Override
	public List<ProductOrderResponse> fetchAllProductOrders() {
		return orderRepository.findAll().stream().map(ProductOrderMapper::entityToDto).collect(Collectors.toList());
		// return null;
	}

	@Override
	public ProductOrderResponse updateProductOrderDeliveryStatus(UpdateStatusDto updateStatusDto) {
		ProductOrder order = orderRepository.findById(updateStatusDto.getOrderId())
				.orElseThrow(() -> new ProductOrderIdNotFoundException("productOrderId", "Not found"));

		if (order.getOrderStatus().equals(OrderStatus.Delivered))
			throw new InvalidOrderUpdateStatusException("status", "Product already delivered");

		if (order.getOrderStatus().equals(OrderStatus.Cancelled))
			throw new InvalidOrderUpdateStatusException("status", "Product delivery was already cancelled");

		if (updateStatusDto.getStatus().equals(OrderStatus.Delivered.toString()))
			order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));

		if (updateStatusDto.getStatus().equals(OrderStatus.Cancelled.toString()))
			order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));

		if(updateStockService.updateProductStock(order.getProduct().getProductId(), order.getQuantity()))
			return ProductOrderMapper.entityToDto(this.orderRepository.save(order));
		else throw new RuntimeException("Error Updating Stock");
	}

	@Override
	public Map<String, String> createProductOrder(ProductOrderRequest productOrder) {
		return Collections.singletonMap("productOrderId", this.orderRepository.save(ProductOrderMapper.DtoToEntity(productOrder)).getProductOrderId().toString());
	}

}
