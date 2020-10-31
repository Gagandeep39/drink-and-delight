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

import com.cg.inventorysupplierservice.dto.DistributorDto;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.exception.InvalidDataException;
import com.cg.inventorysupplierservice.service.DistributorService;

@RequestMapping(value = "/distributors")
@RestController
public class DistributorController {

	@Autowired
	private DistributorService service;

	@PostMapping
	public Distributor addDistributor(@Valid @RequestBody DistributorDto distributor) throws Exception {

		Distributor distributorObj = service.addDistributor(distributor);
		return distributorObj;
	}

	@GetMapping
	public List<Distributor> fetchAllDistributors() {

		return service.getDistributors();
	}

	@GetMapping(value = "/{id}")
	public Optional<Distributor> fetchDistributorById(@PathVariable Long id) {

		return service.getDistributorById(id);
	}

	@DeleteMapping(value = "/{id}")
	public List<Distributor> deleteDistributorById(@PathVariable Long id) {

		return service.deleteDistributorById(id);
	}

	@PutMapping(value = "/{id}")
	public Distributor updateDistributor(@PathVariable Long id,@Valid @RequestBody DistributorDto distributor) {

		return service.updateDistributor(id, distributor);
	}

}
