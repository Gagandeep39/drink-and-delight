package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.cg.inventorysupplierservice.dto.WarehouseDto;
import com.cg.inventorysupplierservice.entity.Warehouse;

public interface WarehouseService {

	
	List<Warehouse> getWarehouses();

	Optional<Warehouse> getWarehouseById(Long id);

	Warehouse updateWarehouse(Long id, WarehouseDto warehouse) throws Exception;

	List<Warehouse> deleteWarehouseById(Long id);

	Warehouse addWarehouse(WarehouseDto wh);

	Warehouse mapper(WarehouseDto wh);

}
