/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 01:12:57
 * @modify date 2020-11-02 01:12:57
 * @desc Map Data
 */
package com.cg.inventorysupplierservice.helper;

import com.cg.inventorysupplierservice.dto.DistributorDto;
import com.cg.inventorysupplierservice.dto.SupplierDto;
import com.cg.inventorysupplierservice.dto.WarehouseDto;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.entity.Warehouse;

public class GenericMapper {

  public static Distributor distributorDtoToEntity (DistributorDto distributorDto) {
    return Distributor.builder()
      .name(distributorDto.getName())
      .distributorId(distributorDto.getDistributorId() !=null ? distributorDto.getDistributorId() : null )
      .location(distributorDto.getLocation())
      .phoneNo(distributorDto.getPhoneNo())
      .build();
  }

  public static Supplier supplierDtoToEntity (SupplierDto supplierDto) {
    return Supplier.builder()
      .name(supplierDto.getName())
      .supplierId(supplierDto.getSupplierId() !=null ? supplierDto.getSupplierId() : null )
      .location(supplierDto.getLocation())
      .phoneNo(supplierDto.getPhoneNo())
      .build();
  }

  public static Warehouse warehouseDtoToEntity (WarehouseDto warehouseDto) {
    return Warehouse.builder()
      .name(warehouseDto.getName())
      .warehouseId(warehouseDto.getWarehouseId() !=null ? warehouseDto.getWarehouseId() : null )
      .description(warehouseDto.getDescription())
      .build();
  }
}
