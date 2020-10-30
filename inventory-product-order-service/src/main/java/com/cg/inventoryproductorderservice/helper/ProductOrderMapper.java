package com.cg.inventoryproductorderservice.helper;

import java.time.LocalDate;

import com.cg.inventoryproductorderservice.dto.ProductOrderRequest;
import com.cg.inventoryproductorderservice.dto.ProductOrderResponse;
import com.cg.inventoryproductorderservice.entity.Product;
import com.cg.inventoryproductorderservice.entity.ProductOrder;
import com.cg.inventoryproductorderservice.enums.QualityCheck;

public class ProductOrderMapper {

	
	public static ProductOrderResponse entityToDto(ProductOrder productOrder) {
		return ProductOrderResponse.builder()
			.productOrderId(productOrder.getProductOrderId())
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
		// Supplier supplier = new Supplier();
		// supplier.setSupplierId(request.getSupplierId());
		Product product = new Product();
		product.setProductId(request.getProductId());
		// order.setDilveryDate(request.getDeliveryDate());
		// order.setExpiryDate(request.getExpiryDate());
		// order.setOrderStatus(OrderStatus.Processing);
		// order.setSupplier(supplier);
		order.setPricePerUnit(request.getPricePerUnit());
		order.setQuantity(request.getQuantity());
		order.setOrderedOn(LocalDate.now());
		order.setQualityCheck(QualityCheck.valueOf(request.getQualityCheck()));
		order.setProduct(product);
		return order;
	}
}
