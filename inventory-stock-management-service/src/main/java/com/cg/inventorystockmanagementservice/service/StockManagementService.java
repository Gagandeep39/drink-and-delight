package com.cg.inventorystockmanagementservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventorystockmanagementservice.entity.Product;
import com.cg.inventorystockmanagementservice.entity.RawMaterial;
import com.cg.inventorystockmanagementservice.entity.Warehouse;
import com.cg.inventorystockmanagementservice.repository.ProductRepository;
import com.cg.inventorystockmanagementservice.repository.RawMaterialRepository;
import com.cg.inventorystockmanagementservice.repository.WarehouseRepository;

@Service
public class StockManagementService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RawMaterialRepository rawMaterialRepository;
	@Autowired
	private WarehouseRepository warehouseRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id.intValue());
	}

	public List<RawMaterial> getAllRawMaterials() {
		return rawMaterialRepository.findAll();
	}
	public Optional<RawMaterial> getRawMaterialById(Long id) {
		return rawMaterialRepository.findById(id.intValue());
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public RawMaterial saveRawMaterial(RawMaterial rawMaterial) {
		return rawMaterialRepository.save(rawMaterial);
	}

	public String removeProduct(Long id) {
		productRepository.deleteById(id.intValue());
		return "Deleted Successfully";
	}

	public String removeRawMaterial(Long id) {
		rawMaterialRepository.deleteById(id.intValue());
		return "Deleted Successfully";
	}

	public Warehouse saveWarehouse(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}

	public List<Warehouse> getAllWarehouses() {
		return warehouseRepository.findAll();
	}

	public Optional<Warehouse> getWarehouseById(Long id) {
		return warehouseRepository.findById(id.intValue());
	}

}
