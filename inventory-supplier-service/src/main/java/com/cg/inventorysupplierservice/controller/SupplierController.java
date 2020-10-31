package com.cg.inventorysupplierservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventorysupplierservice.dto.SupplierDto;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.entity.Warehouse;

import com.cg.inventorysupplierservice.exception.InvalidDataException;
//import com.cg.inventorysupplierservice.service.HelperService;
import com.cg.inventorysupplierservice.service.SupplierService;

@RequestMapping(value = "/suppliers")
@RestController
//@CrossOrigin("http://localhost:4200")

public class SupplierController {

	@Autowired
	private SupplierService service;

	@PostMapping
	public Supplier addSupplier(@Valid @RequestBody SupplierDto supplier) throws Exception {

		return service.addSupplier(supplier);

	}

	@GetMapping
	public List<Supplier> fetchAllSuppliers() {

		return service.getSuppliers();
	}

	@GetMapping(value = "/{id}")
	public Optional<Supplier> fetchSupplierById(@PathVariable Long id) {

		return service.getSupplierById(id);
	}

	@DeleteMapping(value = "/{id}")
	public List<Supplier> deleteSupplierById(@PathVariable Long id) {

		return service.deleteSupplierById(id);
	}

	@PutMapping(value = "/{id}")
	public Supplier updateSupplier(@PathVariable Long id,@Valid  @RequestBody SupplierDto supplier) {

		return service.updateSupplier(id, supplier);
	}
}
