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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UpdateStockServiceImpl implements UpdateStockService {

  private final RestTemplate restTemplate;

  // @Async
  @Override
  public boolean updateProductStock(Long rawMaterialId, Double quantity) {

    // Prepare header
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");
    ObjectMapper mapper = new ObjectMapper();
    String requestBody;
    try {
      requestBody = mapper.writeValueAsString(new UpdateStockRequest(rawMaterialId, quantity));
      HttpEntity<String> entity = new HttpEntity<String>(requestBody, headers);
      return restTemplate
          .exchange("http://inventory-stock-management-service/rawMaterialStock", HttpMethod.PUT, entity, RawMaterial.class)
          .getStatusCode().is2xxSuccessful();
    } catch (JsonProcessingException e) {
      log.info(e.getMessage());
    }

    // restTemplate.put("http://inventory-stock-management-service/rawMaterialStock", new UpdateStockRequest(rawMaterialId, quantity));
    return false;
  }

}
