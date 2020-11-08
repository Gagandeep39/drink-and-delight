/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 09:37:01
 * @modify date 2020-10-30 09:37:01
 * @desc RM response entity
 */
package com.cg.inventoryrawmaterialorderservice.dto;

import java.time.LocalDate;

import com.cg.inventoryrawmaterialorderservice.entity.Warehouse;
import com.cg.inventoryrawmaterialorderservice.enums.MeasurementUnit;
import com.cg.inventoryrawmaterialorderservice.enums.OrderStatus;
import com.cg.inventoryrawmaterialorderservice.enums.QualityCheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialOrderResponse {

  private Long rawMaterialOrderId;
  private Double pricePerUnit;
  private Double quantity;
  private QualityCheck qualityCheck;
  private OrderStatus orderStatus;
  private LocalDate deliveryDate;
  private LocalDate expiryDate;
  private LocalDate orderedOn;
  private String supplierName;
  private Long supplierId;
  private String materialName;
  private String description;
  private MeasurementUnit measurementUnit;
  private Warehouse warehouse;

}
