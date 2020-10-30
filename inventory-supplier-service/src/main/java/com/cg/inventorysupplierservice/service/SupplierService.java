package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.inventorysupplierservice.entity.Supplier;

public interface SupplierService {

	Supplier addSupplier(Supplier supplier);

	List<Supplier> getSuppliers();

	Optional<Supplier> getSupplierById(Long id);

	List<Supplier> deleteSupplierById(Long id);

	Supplier updateSupplier(Long id, Supplier supplier);

}
