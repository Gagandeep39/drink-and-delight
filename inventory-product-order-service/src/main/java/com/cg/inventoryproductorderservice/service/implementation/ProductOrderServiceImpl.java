package com.cg.inventoryproductorderservice.service.implementation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

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

@Service
@Slf4j
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	private ProductOrderRepository orderRepository;

	@Override
	public ProductOrderResponse fetchProductOrderById(long productOrderId) {
		return ProductOrderMapper.entityToDto(this.orderRepository.findById(productOrderId)
				.orElseThrow(() -> new ProductOrderIdNotFoundException("productOrderId", "Not found")));
	}

	@Override
	public List<ProductOrderResponse> fetchAllProductOrders() {
		log.info(orderRepository.findAll().toString());
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

		order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));
		return ProductOrderMapper.entityToDto(this.orderRepository.save(order));

	}

	@Override
	public Map<String, String> createProductOrder(ProductOrderRequest productOrder) {
		return Collections.singletonMap("productOrderId", this.orderRepository.save(ProductOrderMapper.DtoToEntity(productOrder)).getProductOrderId().toString());
	}

}
