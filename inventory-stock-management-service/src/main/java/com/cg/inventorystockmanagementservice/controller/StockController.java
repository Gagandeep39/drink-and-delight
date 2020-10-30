package com.cg.inventorystockmanagementservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.cg.inventoryauthservice.exception.ErrorResponse;
import com.cg.inventorystockmanagementservice.entity.Product;
import com.cg.inventorystockmanagementservice.entity.RawMaterial;
import com.cg.inventorystockmanagementservice.service.StockManagementService;

@RestController
public class StockController {

	@Autowired
	private StockManagementService stockManagementService;

	@GetMapping("/stock/product")
	public ResponseEntity<List<Product>> findAllProducts() {
		List<Product> productList = stockManagementService.getAllProducts();
		if(productList.isEmpty())
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productList);
		else
			return ResponseEntity.status(HttpStatus.OK).body(productList);
	}

	@GetMapping("/stock/product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable(name="id") Long id) {
		Optional<Product> fetchedProduct = stockManagementService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(fetchedProduct.get());	
	}

	@GetMapping("/stock/rawMaterial")
	public List<RawMaterial> findAllRawMaterials() {
		return stockManagementService.getAllRawMaterials();
	}

	@GetMapping("/stock/rawMaterial/{id}")
	public Optional<RawMaterial> findRawMaterialById(@PathVariable(name="id") Long id) {
		return stockManagementService.getRawMaterialById(id);
	}

	@PostMapping("/stock/product")
	public Product addProduct(@RequestBody Product product) {
		return stockManagementService.saveProduct(product);
	}

	@PostMapping("/stock/rawMaterial")
	public RawMaterial addRawMaterial(@RequestBody RawMaterial rawMaterial) {
		return stockManagementService.saveRawMaterial(rawMaterial);
	}

	@PutMapping("/stock/rawMaterial")
	public RawMaterial updateRawMaterialStock(@PathVariable(name="id") Long id, @RequestBody RawMaterial rawMaterial) {
		Optional<RawMaterial> rawMaterialExisting = stockManagementService.getRawMaterialById(id);
		RawMaterial rawMaterialUpdate = rawMaterialExisting.get();
		rawMaterialUpdate.setQuantityAvailable(rawMaterial.getQuantityAvailable());
		return stockManagementService.saveRawMaterial(rawMaterialUpdate);
	}

	@PutMapping("/stock/Product")
	public Product updateProductStock(@PathVariable(name="id") Long id, @RequestBody Product product) {
		Optional<Product> productExisting = stockManagementService.getProductById(id);
		Product productUpdate = productExisting.get();
		productUpdate.setQuantityAvailable(product.getQuantityAvailable());
		return stockManagementService.saveProduct(productUpdate);
	}

	@DeleteMapping("/stock/product/{id}")
	public String deleteProduct(@PathVariable(name="id") Long id) {
		return stockManagementService.removeProduct(id);
	}

	@DeleteMapping("/stock/rawMaterial/{id}")
	public String deleteRawMaterial(@PathVariable(name="id") Long id) {
		return stockManagementService.removeRawMaterial(id);
	}

}
