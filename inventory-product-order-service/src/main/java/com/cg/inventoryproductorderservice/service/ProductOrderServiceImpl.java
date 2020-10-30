package com.cg.inventoryproductorderservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.inventoryproductorderservice.dao.ProductOrderDao;
import com.cg.inventoryproductorderservice.dto.ProductOrderRequest;
import com.cg.inventoryproductorderservice.dto.ProductOrderResponse;
import com.cg.inventoryproductorderservice.dto.UpdateStatusDto;
import com.cg.inventoryproductorderservice.entity.ProductOrder;
import com.cg.inventoryproductorderservice.enums.OrderStatus;
import com.cg.inventoryproductorderservice.exception.InvalidOrderUpdateStatusException;
import com.cg.inventoryproductorderservice.exception.ProductOrderIdNotFoundException;
import com.cg.inventoryproductorderservice.helper.ProductOrderMapper;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	ProductOrderDao productOrderDao;

	@Override
	public ProductOrderResponse fetchProductOrderById(long productOrderId) {

		return ProductOrderMapper.entityToDto(this.productOrderDao.findById(productOrderId)
				.orElseThrow(() -> new ProductOrderIdNotFoundException("ProductOrderId", "Not found")));
	}

	@Override
	public List<ProductOrderResponse> fetchAllProductOrders() {
		return productOrderDao.findAll().stream().map(ProductOrderMapper::entityToDto).collect(Collectors.toList());
	}

	@Override
	public ProductOrderResponse updateProductOrderDeliveryStatus(UpdateStatusDto updateStatusDto) {
		ProductOrder order = productOrderDao.findById(updateStatusDto.getOrderId())
				.orElseThrow(() -> new ProductOrderIdNotFoundException("ProductOrderId", "Not found"));

		if (order.getOrderStatus().equals(OrderStatus.Delivered))
			throw new InvalidOrderUpdateStatusException("status", "Product already delivered");

		if (order.getOrderStatus().equals(OrderStatus.Cancelled))
			throw new InvalidOrderUpdateStatusException("status", "Product delivery was already cancelled");

		order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));
		return ProductOrderMapper.entityToDto(this.productOrderDao.save(order));

	}

	@Override
	public ProductOrderResponse createProductOrder(ProductOrderRequest productOrder) {
		return fetchProductOrderById(
				this.productOrderDao.save(ProductOrderMapper.DtoToEntity(productOrder)).getProductOrderId());
	}

}
