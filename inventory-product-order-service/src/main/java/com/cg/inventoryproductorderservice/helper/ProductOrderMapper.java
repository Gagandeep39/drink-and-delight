package com.cg.inventoryproductorderservice.helper;

import java.time.LocalDate;

import com.cg.inventoryproductorderservice.dto.ProductOrderRequest;
import com.cg.inventoryproductorderservice.dto.ProductOrderResponse;
import com.cg.inventoryproductorderservice.entity.Distributor;
import com.cg.inventoryproductorderservice.entity.Product;
import com.cg.inventoryproductorderservice.entity.ProductOrder;
import com.cg.inventoryproductorderservice.enums.OrderStatus;
import com.cg.inventoryproductorderservice.enums.QualityCheck;

public class ProductOrderMapper {

	
	public static ProductOrderResponse entityToDto(ProductOrder productOrder) {
		return ProductOrderResponse.builder()
			.productOrderId(productOrder.getProductOrderId())
			.productId(productOrder.getProduct().getProductId())
			.quantity(productOrder.getQuantity())
			.pricePerUnit(productOrder.getPricePerUnit())
			.qualityCheck(productOrder.getQualityCheck())
			.orderStatus(productOrder.getOrderStatus())
			.deliveryDate(productOrder.getDeliveryDate())
			.manufactureDate(productOrder.getManufactureDate())
			.expiryDate(productOrder.getExpiryDate())
			.orderedOn(productOrder.getOrderedOn())
			.distributorName(productOrder.getDistributor().getName())
			.distributorId(productOrder.getDistributor().getDistributorId())
			.productName(productOrder.getProduct().getMaterialName())
			.description(productOrder.getProduct().getDescription())
			.measurementUnit(productOrder.getProduct().getQuantityUnit())
			.warehouse(productOrder.getProduct().getWarehouse())
			.build();
	}
	
	
	public static ProductOrder DtoToEntity(ProductOrderRequest request) {
		ProductOrder order = new ProductOrder();
		Distributor distributor = new Distributor();
		distributor.setDistributorId(request.getDistributorId());
		Product product = new Product();
		product.setProductId(request.getProductId());
		order.setProduct(product);
		order.setQuantity(request.getQuantity());
		order.setPricePerUnit(request.getPricePerUnit());
		order.setQualityCheck(QualityCheck.valueOf(request.getQualityCheck()));
		order.setDeliveryDate(request.getDeliveryDate());
		order.setExpiryDate(request.getExpiryDate());
		order.setManufactureDate(request.getManufactureDate());
		order.setOrderStatus(OrderStatus.Processing);
		order.setDistributor(distributor);
		order.setOrderedOn(LocalDate.now());
		return order;
	}
}
