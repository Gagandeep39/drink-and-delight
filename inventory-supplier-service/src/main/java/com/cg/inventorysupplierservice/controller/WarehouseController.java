package com.cg.inventorysupplierservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventorysupplierservice.entity.Warehouse;
import com.cg.inventorysupplierservice.service.WarehouseService;

@RequestMapping("/warehouse")
@RestController
public class WarehouseController {

	@Autowired
	private WarehouseService service;

	@PostMapping
	public Warehouse addWarehouse(@RequestBody Warehouse wh) {
		Warehouse warehouse = null;
		warehouse = service.addWarehouse(wh);
		return warehouse;
	}

	@GetMapping
	public List<Warehouse> fetchAllWarehouses() {
		return service.getWarehouses();
	}

	@GetMapping(value = "/{id}")
	public Optional<Warehouse> fetchWarehousesById(@PathVariable Long id) {
		return service.getWarehouseById(id);
	}

	@DeleteMapping(value = "/{id}")
	public List<Warehouse> deleteWarehousesById(@PathVariable Long id) {

		return service.deleteWarehouseById(id);
	}

	@PutMapping(value = "/{id}")
	public Warehouse updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouse) throws Exception {

		return service.updateWarehouse(id, warehouse);
	}

}
