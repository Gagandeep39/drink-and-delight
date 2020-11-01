/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 01:40:33
 * @modify date 2020-11-02 01:40:33
 * @desc Supplier Bussiness Logi Interface
 */
package com.cg.inventorysupplierservice.service;

import java.util.List;

import com.cg.inventorysupplierservice.dto.SupplierDto;
import com.cg.inventorysupplierservice.entity.Supplier;

public interface SupplierService {
  Supplier addSupplier(SupplierDto supplier);

  List<Supplier> getSuppliers();

  Supplier getSupplierById(Long id);
}
