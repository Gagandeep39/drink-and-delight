/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 15:18:33
 * @modify date 2020-10-30 15:18:33
 * @desc Mapps entitty to DTO
 */
package com.cg.inventoryrawmaterialorderservice.helper;

import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderResponse;
import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;

public class RawMaterialMapper {

  public static RawMaterialOrderResponse entityToDto (RawMaterialOrder rawMaterialOrder) {
    return RawMaterialOrderResponse.builder()
      .materialName(rawMaterialOrder.getRawMaterial().getMaterialName())
      .rawMaterialOrderId(rawMaterialOrder.getRawMaterialOrderId())
      .quantity(rawMaterialOrder.getQuantity())
      .qualityCheck(rawMaterialOrder.getQualityCheck())
      .orderStatus(rawMaterialOrder.getOrderStatus())
      .deliveryDate(rawMaterialOrder.getDeliveryDate())
      .expiryDate(rawMaterialOrder.getExpiryDate())
      .orderedOn(rawMaterialOrder.getOrderedOn())
      .supplierName(rawMaterialOrder.getSupplier().getName())
      .supplierId(rawMaterialOrder.getSupplier().getSupplierId())
      .warehouse(rawMaterialOrder.getRawMaterial().getWarehouse())
      .measurementUnit(rawMaterialOrder.getRawMaterial().getQuantityUnit())
      .description(rawMaterialOrder.getRawMaterial().getDescription())
      .build();
  }
}
