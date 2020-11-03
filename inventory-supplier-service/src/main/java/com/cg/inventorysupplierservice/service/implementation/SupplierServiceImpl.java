/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 01:43:06
 * @modify date 2020-11-02 01:43:06
 * @desc Supplier service Impl
 */
package com.cg.inventorysupplierservice.service.implementation;

import java.util.List;

import com.cg.inventorysupplierservice.dto.SupplierDto;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.exception.NotFoundException;
import com.cg.inventorysupplierservice.helper.GenericMapper;
import com.cg.inventorysupplierservice.repository.SupplierRepository;
import com.cg.inventorysupplierservice.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

  @Autowired
  private SupplierRepository repository;

  @Override
  public Supplier addSupplier(SupplierDto supplier) {
    return repository.save(GenericMapper.supplierDtoToEntity(supplier));
  }

  @Override
  public List<Supplier> getSuppliers() {
    return repository.findAll();
  }

  @Override
  public Supplier getSupplierById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("supplierId", "Supplier Not found"));
  }

}
