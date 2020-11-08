package com.cg.inventorysupplierservice.controller;

import java.util.List;

import javax.validation.Valid;

import com.cg.inventorysupplierservice.dto.SupplierDto;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.service.SupplierService;

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
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

  @Autowired
  private SupplierService service;

  @PostMapping
  public ResponseEntity<Supplier> addSupplier(@Valid @RequestBody SupplierDto supplier) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.addSupplier(supplier));
  }

  @GetMapping
  public ResponseEntity<List<Supplier>> fetchAllSupplier() {
    return ResponseEntity.status(HttpStatus.OK).body(service.getSuppliers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Supplier> fetchSupplierById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.getSupplierById(id));
  }

  @PutMapping
  public ResponseEntity<Supplier> updateSupplier(@Valid @RequestBody SupplierDto supplier) {
    return ResponseEntity.status(HttpStatus.OK).body(service.addSupplier(supplier));
  }

}
