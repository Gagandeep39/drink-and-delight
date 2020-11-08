/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-30 15:18:33
 * @modify date 2020-10-30 15:18:33
 * @desc Mapps entitty to DTO
 */
package com.cg.inventoryrawmaterialorderservice.helper;

import java.time.LocalDate;

import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderRequest;
import com.cg.inventoryrawmaterialorderservice.dto.RawMaterialOrderResponse;
import com.cg.inventoryrawmaterialorderservice.entity.RawMaterial;
import com.cg.inventoryrawmaterialorderservice.entity.RawMaterialOrder;
import com.cg.inventoryrawmaterialorderservice.entity.Supplier;
import com.cg.inventoryrawmaterialorderservice.enums.OrderStatus;
import com.cg.inventoryrawmaterialorderservice.enums.QualityCheck;

public class RawMaterialMapper {

  public static RawMaterialOrderResponse entityToDto (RawMaterialOrder rawMaterialOrder) {
    return RawMaterialOrderResponse.builder()
      .materialName(rawMaterialOrder.getRawMaterial().getMaterialName())
      .rawMaterialOrderId(rawMaterialOrder.getRawMaterialOrderId())
      .quantity(rawMaterialOrder.getQuantity())
      .pricePerUnit(rawMaterialOrder.getPricePerUnit())
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

  
  public static RawMaterialOrder DtoToEntity(RawMaterialOrderRequest request) {
    RawMaterialOrder order = new RawMaterialOrder();
    Supplier supplier = new Supplier();
    supplier.setSupplierId(request.getSupplierId());
    RawMaterial rawMaterial = new RawMaterial();
    rawMaterial.setRawMaterialId(request.getRawMaterialId());
    order.setDeliveryDate(request.getDeliveryDate());
    order.setExpiryDate(request.getExpiryDate());
    order.setOrderStatus(OrderStatus.Processing);
    order.setSupplier(supplier);
    order.setPricePerUnit(request.getPricePerUnit());
    order.setQuantity(request.getQuantity());
    order.setOrderedOn(LocalDate.now());
    order.setQualityCheck(QualityCheck.valueOf(request.getQualityCheck()));
    order.setRawMaterial(rawMaterial);
    return order;
  }
}
