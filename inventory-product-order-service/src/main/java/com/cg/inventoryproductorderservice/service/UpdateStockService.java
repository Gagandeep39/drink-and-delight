/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 02:28:55
 * @modify date 2020-10-31 02:28:55
 * @desc Creates inter microservice communicaton
 */
package com.cg.inventoryproductorderservice.service;

import com.cg.inventoryproductorderservice.entity.Product;

public interface UpdateStockService {

  Product updateProductStock(Long productId, Double quantity);

}
