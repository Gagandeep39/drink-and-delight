/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 02:09:40
 * @modify date 2020-11-02 02:09:40
 * @desc Warehouse COntroller
 */
package com.cg.inventorysupplierservice.controller;

import java.util.List;

import javax.validation.Valid;

import com.cg.inventorysupplierservice.dto.WarehouseDto;
import com.cg.inventorysupplierservice.entity.Warehouse;
import com.cg.inventorysupplierservice.service.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin(origins = "*")
public class WarehouseController {

  @Autowired
  private WarehouseService service;

  @PostMapping
  public ResponseEntity<Warehouse> addWarehouse(@Valid @RequestBody WarehouseDto warehouse) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createWarehouse(warehouse));
  }

  @GetMapping
  public ResponseEntity<List<Warehouse>> fetchAllWarehouses() {
    return ResponseEntity.status(HttpStatus.OK).body(service.getWarehouses());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Warehouse> fetchWarehouseById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.fetchWarehouseById(id));
  }

  @PutMapping
  public ResponseEntity<Warehouse> updateWarehouse(@Valid @RequestBody WarehouseDto warehouse) {
    return ResponseEntity.status(HttpStatus.OK).body(service.createWarehouse(warehouse));
  }

}
