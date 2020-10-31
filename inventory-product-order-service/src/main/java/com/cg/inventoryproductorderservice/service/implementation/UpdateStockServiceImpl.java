/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 02:31:27
 * @modify date 2020-10-31 02:31:27
 * @desc Update stock Implementation
 */
package com.cg.inventoryproductorderservice.service.implementation;

import com.cg.inventoryproductorderservice.dto.UpdateStockRequest;
import com.cg.inventoryproductorderservice.entity.Product;
import com.cg.inventoryproductorderservice.service.UpdateStockService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateStockServiceImpl implements UpdateStockService {

  private final RestTemplate restTemplate;
  
  @Override
  public Product updateProductStock(Long productId, Double quantity) {
    restTemplate.put("http://inventory-stock-management-service/productStock", new UpdateStockRequest(productId, quantity));
    return null;
  }

}
