/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 02:07:59
 * @modify date 2020-11-02 02:07:59
 * @desc Warehouse service Impl
 */
package com.cg.inventorysupplierservice.service.implementation;

import java.util.List;

import com.cg.inventorysupplierservice.dto.WarehouseDto;
import com.cg.inventorysupplierservice.entity.Warehouse;
import com.cg.inventorysupplierservice.exception.NotFoundException;
import com.cg.inventorysupplierservice.helper.GenericMapper;
import com.cg.inventorysupplierservice.repository.WarehouseRepository;
import com.cg.inventorysupplierservice.service.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

  @Autowired
  private WarehouseRepository repository;

  @Override
  public Warehouse createWarehouse(WarehouseDto warehouse) {
    return repository.save(GenericMapper.warehouseDtoToEntity(warehouse));
  }

  @Override
  public List<Warehouse> getWarehouses() {
    return repository.findAll();
  }

  @Override
  public Warehouse fetchWarehouseById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("warehouseId", "Warehouse Not found"));
  }
  
}
