/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 23:42:37
 * @modify date 2020-10-30 23:42:37
 * @desc [description]
 */
package com.cg.inventoryproductorderservice.dto;

import java.time.LocalDate;

import com.cg.inventoryproductorderservice.entity.Warehouse;
import com.cg.inventoryproductorderservice.enums.MeasurementUnit;
import com.cg.inventoryproductorderservice.enums.OrderStatus;
import com.cg.inventoryproductorderservice.enums.QualityCheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderResponse {

	private Long productOrderId;
	private Double quantity;
	private Double pricePerUnit;
	private QualityCheck qualityCheck;
	private OrderStatus orderStatus;
	private LocalDate deliveryDate;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private LocalDate orderedOn;
	private String distributorName;
	private Long distributorId;
	private String productName;
	private String description;
	private MeasurementUnit measurementUnit;
	private Warehouse warehouse;
	private Long productId;
}
