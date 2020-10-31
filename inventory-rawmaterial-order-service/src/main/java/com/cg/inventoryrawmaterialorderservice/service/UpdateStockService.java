/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 02:28:55
 * @modify date 2020-10-31 02:28:55
 * @desc Creates inter microservice communicaton
 */
package com.cg.inventoryrawmaterialorderservice.service;

import com.cg.inventoryrawmaterialorderservice.entity.RawMaterial;

public interface UpdateStockService {

  RawMaterial updateProductStock(Long productId, Double quantity);

}
