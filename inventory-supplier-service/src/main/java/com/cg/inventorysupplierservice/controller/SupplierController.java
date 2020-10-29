package com.cg.inventorysupplierservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.entity.Warehouse;
import com.cg.inventorysupplierservice.exception.InvalidMobileNumberException;
import com.cg.inventorysupplierservice.exception.InvalidDataException;
import com.cg.inventorysupplierservice.service.HelperService;

@RestController
//@CrossOrigin("http://localhost:4200")
//@RequestMapping("/drinkanddelight")
public class SupplierController {

	@Autowired
	private HelperService service;

	@RequestMapping(value = "/warehouse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Warehouse addWarehouse(@RequestBody Warehouse wh) throws Exception {

		boolean result = service.validateWarehouse(wh);
		Warehouse whObj = null;

		if (result == true) {
			whObj = service.addWarehouse(wh);
			return whObj;
		} else
			throw new InvalidDataException("Null request! Parameter value cannot be null");

	}

	@RequestMapping(value = "/warehouse", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Warehouse> fetchAllWarehouses() {

		
		return service.getWarehouses();
	}

	@RequestMapping(value = "/distributors", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Distributor addDistributor(@RequestBody Distributor distributor) throws Exception {
		boolean result = service.validateDistributor(distributor);
		if (result == true) {
			Distributor distributorObj = service.addDistributor(distributor);
			return distributorObj;
		} else
			throw new InvalidDataException("Null Request! Parameter value cannot be null");
	}

	@RequestMapping(value = "/distributors", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Distributor> fetchAllDistributors() {

		return service.getDistributors();
	}

	@RequestMapping(value = "/suppliers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Supplier addSupplier(@RequestBody Supplier supplier) throws Exception {
		boolean result = service.validateSupplier(supplier);
		if (result == true) {
			result = service.validateMobileNo(supplier);
			if (result == true)
				return service.addSupplier(supplier);
			else
				throw new InvalidMobileNumberException("Enter valid mobile no");
		} else
			throw new InvalidDataException("parameter cannot be null");
	}

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Supplier> fetchAllSuppliers() {

		return service.getSuppliers();
	}
}
