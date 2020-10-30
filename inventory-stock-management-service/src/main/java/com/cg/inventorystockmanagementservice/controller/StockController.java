package com.cg.inventorystockmanagementservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Product> findAllProducts() {
		return stockManagementService.getAllProducts();
	}

	@GetMapping("/stock/product/{id}")
	public Optional<Product> findProductById(@PathVariable Long id) {
		return stockManagementService.getProductById(id);
	}

	@GetMapping("/stock/rawMaterial")
	public List<RawMaterial> findAllRawMaterials() {
		return stockManagementService.getAllRawMaterials();
	}

	@GetMapping("/stock/rawMaterial/{id}")
	public RawMaterial findRawMaterialById(@PathVariable Long id) {
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
	}

	@DeleteMapping("/stock/product/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return stockManagementService.removeProduct(id);
	}

	@DeleteMapping("/stock/rawMaterial/{id}")
	public String deleteRawMaterial(@PathVariable Long id) {
		return stockManagementService.removeRawMaterial(id);
	}
	
	@PostMapping("/stock/warehouse")
	public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
		return stockManagementService.saveWarehouse(warehouse);
	}
	
	@GetMapping("/stock/warehouse")
	public List<Warehouse> findAllWarehouses() {
		return stockManagementService.getAllWarehouses();
	}
	
	@GetMapping("/stock/warehouse/{id}")
	public Optional<Warehouse> findWarehouseById(@PathVariable Long id) {
		return stockManagementService.getWarehouseById(id);
	}

}
