package com.cg.inventorystockmanagementservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventorystockmanagementservice.entity.Product;
import com.cg.inventorystockmanagementservice.entity.RawMaterial;
import com.cg.inventorystockmanagementservice.entity.Warehouse;
import com.cg.inventorystockmanagementservice.exception.EntityNotFoundException;
import com.cg.inventorystockmanagementservice.exception.InvalidDataException;
import com.cg.inventorystockmanagementservice.service.StockManagementService;

@RestController
@CrossOrigin("http://localhost:4200")
public class StockController {

	@Autowired
	private StockManagementService stockManagementService;

	@GetMapping("/stock/product")
	public ResponseEntity<List<Product>> findAllProducts() {
		List<Product> productList = stockManagementService.getAllProducts();
		if(productList.isEmpty())
			throw new InvalidDataException();
		
		else
			return ResponseEntity.status(HttpStatus.OK).body(productList);
	}

	@GetMapping("/stock/product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable(name="id") Long id) {
		Optional<Product> fetchedProduct = stockManagementService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(fetchedProduct.get());	
	}
	
	@GetMapping("/stock/product/")
	public ResponseEntity<Product> wrongRequest() {
		throw new InvalidDataException();
	}
	
	@GetMapping("/stock/rawMaterial/")
	public ResponseEntity<Product> wrongRequestTwo() {
		throw new InvalidDataException();
	}

	@GetMapping("/stock/rawMaterial")
	public List<RawMaterial> findAllRawMaterials() {
		return stockManagementService.getAllRawMaterials();
	}

//	@GetMapping("/stock/rawMaterial/{id}")
//	public Optional<RawMaterial> findRawMaterialById(@PathVariable(name="id") Long id) {
//		return stockManagementService.getRawMaterialById(id);
//	}

	@PostMapping("/stock/product")
	public Product addProduct(@RequestBody Product product) {
		if(product.getMaterialName()==null&&product.getDescription()==null&&product.getQuantityAvailable()==null&&product.getQuantityUnit()==null&&product.getWarehouse()==null)
			throw new InvalidDataException();
		else
		return stockManagementService.saveProduct(product);
	}

	@PostMapping("/stock/rawMaterial")
	public RawMaterial addRawMaterial(@RequestBody RawMaterial rawMaterial) {
		if(rawMaterial==null)
			throw new InvalidDataException();
		else
		return stockManagementService.saveRawMaterial(rawMaterial);
	}

//	@PutMapping("/stock/rawMaterial/{id}")
//	public RawMaterial updateRawMaterialStock(@PathVariable(name="id") Long id, @RequestBody RawMaterial rawMaterial) {
//		if(rawMaterial==null)
//			throw new RuntimeException("Request Body cannot be Empty");
//		Optional<RawMaterial> rawMaterialExisting = stockManagementService.getRawMaterialById(id);
//		RawMaterial rawMaterialUpdate = rawMaterialExisting.get();
//		rawMaterialUpdate.setQuantityAvailable(rawMaterial.getQuantityAvailable());
//		return stockManagementService.saveRawMaterial(rawMaterialUpdate);
//	}
	
	
	@PutMapping("/stock/product/")
	public void wrongMethodTwo() {
		throw new InvalidDataException();
	}
	
	@PutMapping("/stock/rawMaterial/")
	public void wrongMethodThree() {
		throw new InvalidDataException();
	}

	@PutMapping("/stock/product/{id}")
	public Product updateProductStock(@PathVariable(name="id") Long id, @RequestBody Product product) {
		if(product.getMaterialName()==null&&product.getDescription()==null&&product.getQuantityAvailable()==null&&product.getQuantityUnit()==null&&product.getWarehouse()==null)
			throw new InvalidDataException();
		Optional<Product> productExisting = stockManagementService.getProductById(id.longValue());
		Product productUpdate = productExisting.get();
		productUpdate.setQuantityAvailable(product.getQuantityAvailable());
		return stockManagementService.saveProduct(productUpdate);
	}

	@DeleteMapping("/stock/product/{id}")
	public String deleteProduct(@PathVariable(name="id") Long id) {
		return stockManagementService.removeProduct(id);
	}
	
	@DeleteMapping("/stock/product/")
	public void wrongRequestFour() {
		throw new InvalidDataException();
	}
	
	@DeleteMapping("/stock/rawMaterial/")
	public void wrongRequestFive() {
		throw new InvalidDataException();
	}

	@DeleteMapping("/stock/rawMaterial/{id}")
	public String deleteRawMaterial(@PathVariable(name="id") Long id) {
		return stockManagementService.removeRawMaterial(id);
	}

}
