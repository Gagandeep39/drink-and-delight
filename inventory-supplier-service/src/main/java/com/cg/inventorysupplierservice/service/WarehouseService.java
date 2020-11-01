/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 02:06:30
 * @modify date 2020-11-02 02:06:30
 * @desc Warehouse Crud operations
 */
package com.cg.inventorysupplierservice.service;

import java.util.List;

import com.cg.inventorysupplierservice.dto.WarehouseDto;
import com.cg.inventorysupplierservice.entity.Warehouse;

public interface WarehouseService {

  Warehouse createWarehouse(WarehouseDto warehouse);

  List<Warehouse> getWarehouses();

  Warehouse fetchWarehouseById(Long id);

}
