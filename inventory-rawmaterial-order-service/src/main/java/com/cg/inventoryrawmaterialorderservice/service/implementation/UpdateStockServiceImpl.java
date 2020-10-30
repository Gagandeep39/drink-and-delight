/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-31 02:31:27
 * @modify date 2020-10-31 02:31:27
 * @desc Update stock Implementation
 */
package com.cg.inventoryrawmaterialorderservice.service.implementation;

import com.cg.inventoryrawmaterialorderservice.dto.UpdateStockRequest;
import com.cg.inventoryrawmaterialorderservice.entity.RawMaterial;
import com.cg.inventoryrawmaterialorderservice.service.UpdateStockService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateStockServiceImpl implements UpdateStockService {

  @Qualifier("loadbalanced")
  private final RestTemplate restTemplate;

  @Async
  @Override
  public RawMaterial updateProductStock(Long rawMaterialId, Double quantity) {
    restTemplate.put("http://inventory-stock-management-service/rawMaterialStock", new UpdateStockRequest(rawMaterialId, quantity));
    return null;
  }

}
