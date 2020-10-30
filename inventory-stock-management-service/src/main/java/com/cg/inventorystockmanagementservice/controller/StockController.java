package com.cg.inventorystockmanagementservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> Stashed changes
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
import com.cg.inventorystockmanagementservice.service.StockManagementService;

@RestController
public class StockController {

	@Autowired
	private StockManagementService stockManagementService;

	@GetMapping("/stock/product")
<<<<<<< Updated upstream
	public List<Product> findAllProducts() {
		return stockManagementService.getAllProducts();
	}

	@GetMapping("/stock/product/{id}")
	public Optional<Product> findProductById(@PathVariable Long id) {
		return stockManagementService.getProductById(id);
=======
	public ResponseEntity<List<Product>> findAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getAllProducts());
	}

	@GetMapping("/stock/product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable Long id) {
		Optional<Product> fetchedProduct = stockManagementService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(fetchedProduct.get());
		
>>>>>>> Stashed changes
	}

	@GetMapping("/stock/rawMaterial")
	public List<RawMaterial> findAllRawMaterials() {
		return stockManagementService.getAllRawMaterials();
	}

	@GetMapping("/stock/rawMaterial/{id}")
<<<<<<< Updated upstream
	public RawMaterial findRawMaterialById(@PathVariable Long id) {
=======
	public Optional<RawMaterial> findRawMaterialById(@PathVariable Long id) {
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
	@PutMapping("/stock/rawMaterial/{id}")
	public RawMaterial updateRawMaterialStock(@PathVariable Long id, @RequestBody RawMaterial rawMaterial) {
		RawMaterial rawMaterialExisting = stockManagementService.getRawMaterialById(id.intValue());
		rawMaterialExisting.setQuantityAvailable(rawMaterial.getQuantityAvailable());
		return stockManagementService.saveRawMaterial(rawMaterialExisting);
	}

	@PutMapping("/stock/product/{id}")
	public Product updateProductStock(@PathVariable Long id, @RequestBody Product product) {
		Product productExisting = stockManagementService.getProductById(id.intValue());
		productExisting.setQuantityAvailable(product.getQuantityAvailable());
		return stockManagementService.saveProduct(productExisting);
=======
	@PutMapping("/stock/rawMaterial")
	public RawMaterial updateRawMaterialStock(@PathVariable Long id, @RequestBody RawMaterial rawMaterial) {
		Optional<RawMaterial> rawMaterialExisting = stockManagementService.getRawMaterialById(id);
		RawMaterial rawMaterialUpdate = rawMaterialExisting.get();
		rawMaterialUpdate.setQuantityAvailable(rawMaterial.getQuantityAvailable());
		return stockManagementService.saveRawMaterial(rawMaterialUpdate);
	}

	@PutMapping("/stock/Product")
	public Product updateProductStock(@PathVariable Long id, @RequestBody Product product) {
		Optional<Product> productExisting = stockManagementService.getProductById(id);
		Product productUpdate = productExisting.get();
		productUpdate.setQuantityAvailable(product.getQuantityAvailable());
		return stockManagementService.saveProduct(productUpdate);
>>>>>>> Stashed changes
	}

	@DeleteMapping("/stock/product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return stockManagementService.removeProduct(id);
	}

	@DeleteMapping("/stock/rawMaterial/{id}")
	public String deleteRawMaterial(@PathVariable Long id) {
		return stockManagementService.removeRawMaterial(id);
	}
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	@PostMapping("/stock/warehouse")
	public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
		return stockManagementService.saveWarehouse(warehouse);
	}
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	@GetMapping("/stock/warehouse")
	public List<Warehouse> findAllWarehouses() {
		return stockManagementService.getAllWarehouses();
	}
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	@GetMapping("/stock/warehouse/{id}")
	public Optional<Warehouse> findWarehouseById(@PathVariable Long id) {
		return stockManagementService.getWarehouseById(id);
	}

}
