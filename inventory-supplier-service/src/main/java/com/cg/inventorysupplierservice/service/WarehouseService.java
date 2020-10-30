package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.inventorysupplierservice.entity.Warehouse;

public interface WarehouseService {

	Warehouse addWarehouse(Warehouse wh);

	List<Warehouse> getWarehouses();

	Optional<Warehouse> getWarehouseById(Long id);

	Warehouse updateWarehouse(Long id, Warehouse warehouse) throws Exception;

	List<Warehouse> deleteWarehouseById(Long id);

}
