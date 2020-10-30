/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 01:16:53
 * @modify date 2020-10-31 01:16:53
 * @desc Stock management Service
 */
package com.cg.inventorystockmanagementservice.service;

import java.util.List;

import com.cg.inventorystockmanagementservice.entity.Product;
import com.cg.inventorystockmanagementservice.entity.ProductStockRequest;
import com.cg.inventorystockmanagementservice.entity.RawMaterial;
import com.cg.inventorystockmanagementservice.entity.RawMaterialStockRequest;

public interface StockManagementService {

  List<Product> getAllProducts() ;

	Product getProductById(Long id) ;

	List<RawMaterial> getAllRawMaterials() ;

	RawMaterial getRawMaterialById(Long id) ;

	Product saveProduct(Product product) ;

  RawMaterial saveRawMaterial(RawMaterial rawMaterial);
  
  Product updateProductStock(ProductStockRequest stockRequest);

  RawMaterial updateRawMaterialStock(RawMaterialStockRequest stockRequest);
}
