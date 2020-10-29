package com.cg.inventorysupplierservice.service;

import java.util.List;

import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.entity.Warehouse;

public interface HelperService {

	Warehouse addWarehouse(Warehouse wh);

	Distributor addDistributor(Distributor distributor);

	Supplier addSupplier(Supplier supplier);

	List<Warehouse> getWarehouses();

	List<Distributor> getDistributors();

	List<Supplier> getSuppliers();

	boolean validateWarehouse(Warehouse wh);

	boolean validateDistributor(Distributor distributor);

	boolean validateSupplier(Supplier supplier);

	boolean validateMobileNo(Supplier supplier);

	

}
